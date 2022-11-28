package com.enuaruke.demo;

import com.alibaba.fastjson.JSON;
import com.enuaruke.annotation.Result;
import com.enuaruke.demo.model.RiskModelParameter;
import com.enuaruke.demo.model.Rule;
import com.enuaruke.utils.FileUtil;
import com.enuaruke.utils.KeyGenerator;
import com.enuaruke.utils.file.EnuFileUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author: 05
 * @date: 2022-11-22 10:00
 */
@RestController
@RequestMapping("/demo")
public class DemoController {

    /**
     * 创建评分卡
     */
    @RequestMapping("/createScore")
    public Result createScore(@RequestBody RiskModelParameter parameter){
        if(StringUtils.isEmpty(parameter.getBizNo())){
            return Result.error("业务编号bizNo为空", null);
        }
        if(StringUtils.isEmpty(parameter.getIdCardNo())){
            return Result.error("身份证号码idCardNo为空", null);
        }
        Map riskResultJSON = generateScoreDataModel(parameter.getBizNo(), parameter.getIdCardNo().substring(6, 14));
        Map result = new HashMap();
        Map value = new HashMap();
        value.put("riskResultJSON",riskResultJSON);
        value.put("riskApiStatus", "finish");
        value.put("riskId", KeyGenerator.generateKeys().toLowerCase());
        result.put("value", value);
        return Result.ok(result);
    }

    /**
     * 初审报告
     */
    @RequestMapping("/createReport")
    public Result createReport(@RequestBody RiskModelParameter parameter){
        if(StringUtils.isEmpty(parameter.getBizNo())){
            return Result.error("业务编号bizNo为空", null);
        }
        if(StringUtils.isEmpty(parameter.getIdCardNo())){
            return Result.error("身份证号码idCardNo为空", null);
        }
        Map riskResultJSON = generateReportDataModel(parameter.getBizNo(), parameter.getIdCardNo().substring(6,14));
        Map result = new HashMap();
        Map value = new HashMap();
        value.put("riskResultJSON",riskResultJSON);
        result.put("value", value);
        return Result.ok(result);
    }

    private Map generateReportDataModel(String bizNo, String birth) {
        Map riskResultJSON = new HashMap();
        List modelRuleResults = new ArrayList();
        Random random = new Random();
        if(Integer.valueOf(birth) % 2 != 0) {
            int num = random.nextInt(3) + 1;
            generateRule(modelRuleResults, num);
        }
        riskResultJSON.put("modelRuleResults", modelRuleResults);
        return riskResultJSON;
    }

    private void generateRule(List modelRuleResults, int num) {
        Random random = new Random();
        List list = new ArrayList();
        list.add(new Rule(KeyGenerator.generateKeys().toLowerCase(), "BR12_身份证命中非银中风险距今时间", "三方数据不符合准入"));
        list.add(new Rule(KeyGenerator.generateKeys().toLowerCase(), "FH14_法海_个人_失信公告_匹配度大于等于0.65_立案日期距今月数", "命中司法涉案信息"));
        list.add(new Rule(KeyGenerator.generateKeys().toLowerCase(), "GRZX14_个人征信_近6个月内贷款贷记卡准贷记卡累计逾期合计次数", "征信记录不符合准入"));
        list.add(new Rule(KeyGenerator.generateKeys().toLowerCase(), "GRZX27_近24个月内贷款和信用卡累计逾期合计次数（逾期金额≤1000元的不计入）", "征信记录不符合准入"));
        for (int i = 0; i < num; i++) {
            Object o = list.get(random.nextInt(list.size()));
            list.remove(o);
            modelRuleResults.add(o);
        }
    }

    private Map generateScoreDataModel(String bizNo, String birth) {
        HashMap riskResultJSON = new HashMap();
        HashMap lvl2TableDataCode = new HashMap();
        //工具
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Random random = new Random();
        //装填 lvl2TableDataCode
        lvl2TableDataCode.put("applydatetime", sdf.format(new Date()));
        lvl2TableDataCode.put("biz_no", bizNo);
        BigDecimal score1;
        BigDecimal score2;
        if(Integer.valueOf(birth) % 2 == 0){
            score1 = new BigDecimal(random.nextDouble() * 20 + 30).setScale(2, BigDecimal.ROUND_DOWN);
            score2 = new BigDecimal(random.nextDouble() * 20 + 30).setScale(2, BigDecimal.ROUND_DOWN);
        }else{
            score1 = new BigDecimal(random.nextDouble() * 25).setScale(2, BigDecimal.ROUND_DOWN);
            score2 = new BigDecimal(random.nextDouble() * 25).setScale(2, BigDecimal.ROUND_DOWN);
        }
        lvl2TableDataCode.put("score1", score1);
        lvl2TableDataCode.put("score2", score2);
        lvl2TableDataCode.put("total_score", score1.add(score2));
        //装填riskResultJSON
        riskResultJSON.put("lvl2TableDataCode", lvl2TableDataCode);
        return riskResultJSON;
    }

}
