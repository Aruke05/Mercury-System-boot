package com.enuaruke.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: 05
 * @date: 2022-11-22 14:43
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rule {
    String ruleId;
    String ruleName;
    String ruleRemark;
}
