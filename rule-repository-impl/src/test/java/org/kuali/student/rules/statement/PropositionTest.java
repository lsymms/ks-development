package org.kuali.student.rules.statement;

import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;
import org.kuali.student.rules.internal.common.entity.ComparisonOperator;
import org.kuali.student.rules.internal.common.statement.propositions.AverageProposition;
import org.kuali.student.rules.internal.common.statement.propositions.IntersectionProposition;
import org.kuali.student.rules.internal.common.statement.propositions.MaxProposition;
import org.kuali.student.rules.internal.common.statement.propositions.MinProposition;
import org.kuali.student.rules.internal.common.statement.propositions.SimpleComparableProposition;
import org.kuali.student.rules.internal.common.statement.propositions.SubsetProposition;
import org.kuali.student.rules.internal.common.statement.propositions.SumProposition;
import org.kuali.student.rules.internal.common.utils.BusinessRuleUtil;

public class PropositionTest {

    private Set<String> set1 = new HashSet<String>(Arrays.asList("CHEM101".split(",")));

    private Set<String> set2 = new HashSet<String>(Arrays.asList("MATH101,MATH103,CHEM101".split(",")));

    private Set<String> set3 = new HashSet<String>(Arrays.asList("BIOL101".split(",")));
    
    private List<BigDecimal> creditList = createList("3.0,6.0,3.0");
    private List<BigDecimal> gradeList = createList("85.0,75.0,80.0");

    private List<BigDecimal> createList(String list) {
    	List<BigDecimal> set = new ArrayList<BigDecimal>();
        for( String s : list.split(",") ) {
        	set.add(new BigDecimal(s.trim()));
        }
        return set;
    }
    
    @Test
    public void testSimpleComparableProposition_String() throws Exception {
    	SimpleComparableProposition<String> comparableProp = new SimpleComparableProposition<String>("A",
    			ComparisonOperator.EQUAL_TO, "Hi Kuali", "Hi Kuali");

    	Boolean result = comparableProp.apply();

        Assert.assertTrue(result);
    }
    
    @Test
    public void testSimpleComparableProposition_Double() throws Exception {
    	SimpleComparableProposition<Double> comparableProp = new SimpleComparableProposition<Double>("A",
    			ComparisonOperator.LESS_THAN, new Double("100.1"), new Double(100d));

    	Boolean result = comparableProp.apply();

        Assert.assertTrue(result);
    }
    
    @Test
    public void testSimpleComparableProposition_Integer() throws Exception {
    	SimpleComparableProposition<Integer> comparableProp = new SimpleComparableProposition<Integer>("A",
    			ComparisonOperator.EQUAL_TO, new Integer("100"), new Integer(100));

    	Boolean result = comparableProp.apply();

        Assert.assertTrue(result);
    }
    
    @Test
    public void testSimpleComparableProposition_Long() throws Exception {
    	SimpleComparableProposition<Long> comparableProp = new SimpleComparableProposition<Long>("A",
    			ComparisonOperator.EQUAL_TO, new Long("1000000000000000000"), new Long(1000000000000000000l));

    	Boolean result = comparableProp.apply();

        Assert.assertTrue(result);
    }
    
    @Test
    public void testSimpleComparableProposition_BigDecimal() throws Exception {
    	SimpleComparableProposition<BigDecimal> comparableProp = new SimpleComparableProposition<BigDecimal>("A",
    			ComparisonOperator.GREATER_THAN, new BigDecimal(123.456789), new BigDecimal(999));

    	Boolean result = comparableProp.apply();

        Assert.assertTrue(result);
    }
    
    @Test
    public void testIntersectionTrue() throws Exception {
        IntersectionProposition<String> subsetProp = new IntersectionProposition<String>("A",
                ComparisonOperator.GREATER_THAN_OR_EQUAL_TO, new Integer(1), set1, set2);

        Boolean result = subsetProp.apply();

        Assert.assertTrue(result);
    }

    @Test
    public void testIntersectionFalse() throws Exception {
        IntersectionProposition<String> subsetProp = new IntersectionProposition<String>("A",
                ComparisonOperator.GREATER_THAN_OR_EQUAL_TO, new Integer(2), set1, set2);

        Boolean result = subsetProp.apply();

        Assert.assertFalse(result);
    }

    @Test
    public void testSubsetTrue() throws Exception {
        SubsetProposition<String> subsetProp = new SubsetProposition<String>("A", set1, set2);

        Boolean result = subsetProp.apply();

        Assert.assertTrue(result);
    }

    @Test
    public void testSubsetFalse() throws Exception {

        SubsetProposition<String> subsetProp = new SubsetProposition<String>("A", set3, set2);

        Boolean result = subsetProp.apply();

        Assert.assertFalse(result);
    }

    @Test
    public void testSumTrue() throws Exception {

        SumProposition<BigDecimal> subsetProp = new SumProposition<BigDecimal>("A",
                ComparisonOperator.GREATER_THAN_OR_EQUAL_TO, new BigDecimal(12.0), creditList);

        Boolean result = subsetProp.apply();

        Assert.assertTrue(result);
    }

    @Test
    public void testSumFalse() throws Exception {
        SumProposition<BigDecimal> subsetProp = new SumProposition<BigDecimal>("A",
                ComparisonOperator.LESS_THAN, new BigDecimal(12.0), creditList);

        Boolean result = subsetProp.apply();

        Assert.assertFalse(result);
    }

    @Test
    public void testAverageTrue() throws Exception {
        AverageProposition<BigDecimal> subsetProp = new AverageProposition<BigDecimal>("A",
                ComparisonOperator.GREATER_THAN_OR_EQUAL_TO, new BigDecimal(80.0), gradeList);

        Boolean result = subsetProp.apply();

        Assert.assertTrue(result);
    }

    @Test
    public void testAverageFalse() throws Exception {
    	AverageProposition<BigDecimal> subsetProp = new AverageProposition<BigDecimal>("A",
                ComparisonOperator.EQUAL_TO, new BigDecimal(70.0), gradeList);

        Boolean result = subsetProp.apply();

        Assert.assertFalse(result);
    }

    @Test
    public void testMaxProposition_String() throws Exception {
    	MaxProposition<String> maxProp = new MaxProposition<String>("A",
    			ComparisonOperator.EQUAL_TO, new String("333"), Arrays.asList(new String[]{"1", "22", "333"}));

    	Boolean result = maxProp.apply();

    	Assert.assertTrue(result);
    }
    
    @Test
    public void testMaxProposition_BigDecimal() throws Exception {
    	MaxProposition<BigDecimal> maxProp = new MaxProposition<BigDecimal>("A",
    			ComparisonOperator.GREATER_THAN_OR_EQUAL_TO, new BigDecimal(85.0), gradeList);

    	Boolean result = maxProp.apply();

    	Assert.assertTrue(result);
    }

    @Test
    public void testMaxProposition_Double() throws Exception {
    	MaxProposition<Double> maxProp = new MaxProposition<Double>("A",
    			ComparisonOperator.EQUAL_TO, new Double(3.3), Arrays.asList(new Double[]{new Double(1.1), new Double(2.2), new Double(3.3)}));

    	Boolean result = maxProp.apply();

    	Assert.assertTrue(result);
    }

    @Test
    public void testMaxProposition_Integer() throws Exception {
    	MaxProposition<Integer> maxProp = new MaxProposition<Integer>("A",
    			ComparisonOperator.EQUAL_TO, new Integer(3), Arrays.asList(new Integer[]{new Integer(1), new Integer(2), new Integer(3)}));

    	Boolean result = maxProp.apply();

    	Assert.assertTrue(result);
    }

    @Test
    public void testMaxProposition_Long() throws Exception {
    	MaxProposition<Long> maxProp = new MaxProposition<Long>("A",
    			ComparisonOperator.EQUAL_TO, new Long(3), Arrays.asList(new Long[]{new Long(1), new Long(2), new Long(3)}));

    	Boolean result = maxProp.apply();

    	Assert.assertTrue(result);
    }

    @Test
    public void testMinProposition_String() throws Exception {
    	MinProposition<String> minProp = new MinProposition<String>("A",
    			ComparisonOperator.EQUAL_TO, new String("1"), Arrays.asList(new String[]{"1", "22", "333"}));

    	Boolean result = minProp.apply();

    	Assert.assertTrue(result);
    }

    @Test
    public void testMinProposition_BigDecimal() throws Exception {
    	MinProposition<BigDecimal> minProp = new MinProposition<BigDecimal>("A",
    			ComparisonOperator.GREATER_THAN_OR_EQUAL_TO, new BigDecimal(75.0), gradeList);

    	Boolean result = minProp.apply();

    	Assert.assertTrue(result);
    }

    @Test
    public void testMinProposition_Double() throws Exception {
    	MinProposition<Double> minProp = new MinProposition<Double>("A",
    			ComparisonOperator.EQUAL_TO, new Double(1.1), Arrays.asList(new Double[]{new Double(1.1), new Double(2.2), new Double(3.3)}));

    	Boolean result = minProp.apply();

    	Assert.assertTrue(result);
    }

    @Test
    public void testMinProposition_Integer() throws Exception {
    	MinProposition<Integer> minProp = new MinProposition<Integer>("A",
    			ComparisonOperator.EQUAL_TO, new Integer(1), Arrays.asList(new Integer[]{new Integer(1), new Integer(2), new Integer(3)}));

    	Boolean result = minProp.apply();

    	Assert.assertTrue(result);
    }

    @Test
    public void testMinProposition_Long() throws Exception {
    	MinProposition<Long> minProp = new MinProposition<Long>("A",
    			ComparisonOperator.EQUAL_TO, new Long(1), Arrays.asList(new Long[]{new Long(1), new Long(2), new Long(3)}));

    	Boolean result = minProp.apply();

    	Assert.assertTrue(result);
    }

    @Test
    //@SuppressWarnings("unchecked")
    public void testMinProposition_ConvertDataType() throws Exception {
    	//String comparisonDataType = Long.class.getName();
    	//Class<?> clazz = Class.forName("1".getClass().getName());
    	//T value = (T)BusinessRuleUtil.convertToDataType(clazz, "1");

    	MinProposition<Long> minProp = new MinProposition<Long>("A",
    			ComparisonOperator.EQUAL_TO, new Long(1), Arrays.asList(new Long[]{new Long(1), new Long(2), new Long(3)}));

    	Boolean result = minProp.apply();

    	Assert.assertTrue(result);
    }
}
