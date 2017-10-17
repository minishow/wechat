package com._520it.crm.web.controller;

import com._520it.crm.domain.*;
import com._520it.crm.mapper.OpenStockMapper;
import com._520it.crm.mapper.SpecificMapper;
import com._520it.crm.mapper.StockIncomeMapper;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.StockOprationBillQueryObject;
import com._520it.crm.service.*;
import com._520it.crm.util.*;
import org.apache.commons.io.IOUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.swing.filechooser.FileSystemView;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * Created by Administrator on 2017/9/25.
 */
@Controller
@RequestMapping("/stockOprationBill")
public class StockOprationBillController {
    private static boolean flag = true;
    @Autowired
    private IStockOprationBillService stockOprationBillServiceImpl;
    @Autowired
    private ILocationService locationService;
    @Autowired
    private IProductInfoService productInfoService;
    @Autowired
    private IBrandService brandService;
    @Autowired
    private IProductTypeService productTypeService;
    @Autowired
    private IProductPartService productPartService;
    @Autowired
    private StockIncomeMapper stockIncomeMapper;
    @Autowired
    private SpecificMapper specificMapper;
    @Autowired
    private OpenStockMapper openStockMapper;


    @RequestMapping("")
    public String execute(HttpServletRequest req) {
        req.setAttribute("locations", locationService.selectAll());
        req.setAttribute("brands", brandService.selectAll());
        req.setAttribute("productTypes", productTypeService.selectAll());
        req.setAttribute("stockIncomes", stockIncomeMapper.selectAll());
        req.setAttribute("specifics", specificMapper.selectAll());
        req.setAttribute("productParts", productPartService.selectAll());
        req.setAttribute("openStocks", openStockMapper.selectAll());
        req.setAttribute("productInfos", productInfoService.selectAll());
        return null;
    }

    @RequestMapping("/list")
    @ResponseBody
    public PageResult json(StockOprationBillQueryObject qo) {
        return stockOprationBillServiceImpl.queryForList(qo);
    }


    @RequestMapping("/delete")
    @ResponseBody
    public AjaxObject delete(Long id, boolean state) {
        try {
            stockOprationBillServiceImpl.deleteByPrimaryKey(id);
            return new AjaxObject(true, "删除成功");
        } catch (RuntimeException e) {
            return new AjaxObject(false, "删除失败");
        }

    }

    @RequestMapping("/save")
    @ResponseBody
    public AjaxObject save(StockOprationBill StockOprationBill) {
        try {
            stockOprationBillServiceImpl.insert(StockOprationBill);
            return new AjaxObject(true, "保存成功");
        } catch (RuntimeException e) {
            return new AjaxObject(false, e.getMessage());
        }
    }

    @RequestMapping("/edit")
    @ResponseBody
    @RequiresPermissions("StockOprationBill:edit")
    public AjaxObject edit(StockOprationBill StockOprationBill) {
        try {
            stockOprationBillServiceImpl.updateByPrimaryKey(StockOprationBill);
            return new AjaxObject(true, "编辑成功");
        } catch (RuntimeException e) {
            return new AjaxObject(false, "编辑失败");
        }
    }


    @RequestMapping("/queryLocations")
    @ResponseBody
    public List<Location> queryLocations() {
        return locationService.selectAll();
    }

    @RequestMapping("/queryBrands")
    @ResponseBody
    public List<Brand> queryBrands() {
        return brandService.selectAll();
    }

    @RequestMapping("/queryProductTypes")
    @ResponseBody
    public List<ProductType> queryProductTypes() {
        return productTypeService.selectAll();
    }

    @RequestMapping("/queryStockIncomes")
    @ResponseBody
    public List<StockIncome> queryStockIncomes() {
        return stockIncomeMapper.selectAll();
    }

    @RequestMapping("/querySpecifics")
    @ResponseBody
    public List<Specific> querySpecifics() {
        return specificMapper.selectAll();
    }

    @RequestMapping("/queryOpenStocks")
    @ResponseBody
    public List<OpenStock> queryOpenStocks() {
        return openStockMapper.selectAll();
    }

    @RequestMapping("/queryProductParts")
    @ResponseBody
    public List<ProductPart> queryProductParts() {
        return productPartService.selectAll();
    }

    @RequestMapping("/queryProductInfos")
    @ResponseBody
    public List<ProductInfo> queryProductInfos() {
        return (List<ProductInfo>) productInfoService.selectAll();
    }

    @RequestMapping("/saveStockOprationBills")
    @ResponseBody
    public AjaxObject saveStockOprationBills(StockBIll stockObjects) {
        try {
            stockOprationBillServiceImpl.insertBill(stockObjects);
            System.out.println(stockObjects.getStockObjects());
            return new AjaxObject(true, "编辑成功");
        } catch (RuntimeException e) {
            return new AjaxObject(false, e.getMessage());
        }
    }

    @RequestMapping("/printExcel")
    @ResponseBody
    public AjaxObject printExcel(ExcelObject stockObjects, HttpServletRequest req) {

        try {
/*            URL location = StockOprationBillController.class.getProtectionDomain().getCodeSource().getLocation();
            StockOprationBillController.class.getResource("/").getPath();*/
            FileSystemView fsv = FileSystemView.getFileSystemView();
            fsv.getHomeDirectory();
            String realPath = req.getSession().getServletContext().getRealPath("file");
            System.out.println(realPath);
            Excel.exportExcel(realPath + "/test.xls", stockObjects.getStockObjects());
           /* Vector<ExcelMV> excelMVs = Excel.importExcel("E:\\code\\大神班\\byiaacrm\\src\\main\\webapp\\file\\text1.xls");
            Excel.exportExcel("E:\\code\\大神班\\byiaacrm\\src\\main\\webapp\\file\\text.xls", excelMVs);*/
            return new AjaxObject(true, "编辑成功");
        } catch (Exception e) {
            return new AjaxObject(false, e.getMessage());
        }
    }


    @RequestMapping(value = {"/importExcel"}, method = RequestMethod.POST)
    @ResponseBody
    public Vector<ExcelMV> importExcel(@RequestParam(value = "file", required = true) MultipartFile file,
                                       HttpServletRequest request) {
        try {
            System.out.println(file.getContentType());
            if (!"application/vnd.ms-excel".equals(file.getContentType())) {
                throw new RuntimeException("亲文件类型必须为xls！");
            }
            System.out.println(file.getName());
            System.out.println(file.getOriginalFilename());
            System.out.println(file.getInputStream());
            System.out.println(file.getSize());
            String realPath = request.getSession().getServletContext().getRealPath("file");
            FileOutputStream os = new FileOutputStream(realPath + "/import.xls");
            IOUtils.copy(file.getInputStream(), os);
            Vector<ExcelMV> excelMVs = Excel.importExcel(realPath + "/import.xls");
            System.out.println(excelMVs);
            return excelMVs;
        } catch (RuntimeException e) {
            e.getMessage();
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        }
        return null;
    }


    @RequestMapping(value = {"/saveExcelData"}, method = RequestMethod.POST)
    @ResponseBody
    public AjaxObject excelData(ExcelObject stockBIll) {
        try {
            List<ProductInfo> productInfos = productInfoService.selectAll();
            List<String> pnames = new ArrayList<>();
            List<String> sNmaes = new ArrayList<>();
            List<String> oNames = new ArrayList<>();
            List<String> soNames = new ArrayList<>();
            for (ProductInfo productInfo : productInfos) {
                pnames.add(productInfo.getName());
            }
            List<StockIncome> stockIncomes = stockIncomeMapper.selectAll();
            for (StockIncome stockIncome : stockIncomes) {
                sNmaes.add(stockIncome.getName());
            }
            List<Specific> specifics = specificMapper.selectAll();
            for (Specific specific : specifics) {
                soNames.add(specific.getBeforeSpecific());
            }
            List<OpenStock> openStocks = openStockMapper.selectAll();
            for (OpenStock openStock : openStocks) {
                oNames.add(openStock.getName());
            }
            Vector<ExcelMV> stockObjects = stockBIll.getStockObjects();
            StockBIll bIll = new StockBIll();
            List<StockObject> objects = new ArrayList<>();
            for (ExcelMV stockObject : stockObjects) {

                if (!pnames.contains(stockObject.getProductInfoId())) {
                    throw new RuntimeException("产品表上没有" + stockObject.getProductInfoId() + "产品");
                }
                if (!soNames.contains(stockObject.getSpecificId())) {
                    throw new RuntimeException("原封装方式没有" + stockObject.getSpecificId() + "方式");
                }
                if (!oNames.contains(stockObject.getOpenStockId())) {
                    throw new RuntimeException("拆零表上没有" + stockObject.getOpenStockId() + "方式");
                }
                if (!sNmaes.contains(stockObject.getStockIncomeId())) {
                    throw new RuntimeException("入库方式" + stockObject.getStockIncomeId() + "没有");
                }
                StockObject so = new StockObject();
                so.setProductInfoId(stockOprationBillServiceImpl.queryProductIdByName(stockObject.getProductInfoId()));
                so.setSpecificId(stockOprationBillServiceImpl.querySpecificIdByName(stockObject.getSpecificId()));
                so.setOpenStockId(stockOprationBillServiceImpl.queryOpenStocksIdByName(stockObject.getOpenStockId()));
                so.setStockIncomeId(stockOprationBillServiceImpl.queryStockIncomesIdByName(stockObject.getStockIncomeId()));
                so.setSurvivalTime(stockObject.getSurvivalTime());
                so.setOperation(stockObject.getOperation());
                so.setWarnDate(stockObject.getWarnDate());
                so.setCostPrice(new BigDecimal(stockObject.getCostPrice()));
                so.setInputTime(stockObject.getInputTime());
                so.setProductStockSn(stockObject.getProductStockSn());
                so.setSpecificNumber(Integer.valueOf(stockObject.getSpecificNumber()));
                so.setNumber(Integer.valueOf(stockObject.getNumber()));
                so.setMemberPrice(new BigDecimal(stockObject.getMemberPrice()));
                so.setProductionPrice(new BigDecimal(stockObject.getProductionPrice()));
                so.setWarnNumber(Integer.valueOf(stockObject.getWarnNumber()));
                objects.add(so);

            }
            bIll.setStockObjects(objects);
            stockOprationBillServiceImpl.insertBill(bIll);
            return new AjaxObject(true, "入库成功");
        } catch (Exception e) {
            return new AjaxObject(true, e.getMessage());
        }
    }

  

}