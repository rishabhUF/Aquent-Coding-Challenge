package rishabh.AquentCodingChallenge;

import DataProcessing.DataProcessing;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AquentCodingChallengeApplicationTests {

    DataProcessing dataProcessing = new DataProcessing();
	// Reading Random Data
	@Test
	public void processDataFromList_RandomData()
	{

		List<String> list = new ArrayList<>();
		list.add("order time");
		list.add("Meat  1506176687");
		list.add( "pizza 1477578287");
		TreeMap<Long, TreeSet> map = new TreeMap<>();
		map.put((long) 1506176687,  new TreeSet(Arrays.asList("Meat")));
		map.put((long) 1477578287,  new TreeSet(Arrays.asList("pizza")));
		Assert.assertEquals(map, dataProcessing.processReadData(list));
	}

	//Reading Empty Data
	@Test
	public void processDataFromList_EmptyData()
    {
		List<String> list = new ArrayList<>();
		list.add("order time");
		TreeMap<Long, String> map = new TreeMap<>();
		Assert.assertEquals(map, dataProcessing.processReadData(list));
	}

	// Reading Data in Ascending Order
	@Test
	public void processDataFromList_AscendingOrder()
	{
		List<String> list = new ArrayList<>();
		list.add("order time");
		list.add("Pizza 1477578287");
		list.add("Veggie 1477578298");
		list.add("Mushroom 1477578387");
		list.add("Chicken 1477578487");
		list.add("Delight 1477578587");
		TreeMap<Long, TreeSet> map = new TreeMap<>();
		map.put((long) 1477578287, new TreeSet(Arrays.asList("Pizza")));
		map.put((long) 1477578298, new TreeSet(Arrays.asList("Veggie")));
		map.put((long) 1477578387, new TreeSet(Arrays.asList("Mushroom")));
		map.put((long) 1477578487, new TreeSet(Arrays.asList("Chicken")));
		map.put((long) 1477578587, new TreeSet(Arrays.asList("Delight")));
		Assert.assertEquals(map, dataProcessing.processReadData(list));
	}

	// Reading Data in Descending Order
	@Test
	public void processDataFromList_DescendingOrder()
	{
		List<String> list = new ArrayList<>();
		list.add("order time");
		list.add("Veggie 1477578298");
		list.add("Mushroom 1477578387");
		list.add("Chicken 1477578487");
		list.add("Delight 1477578587");
		list.add("Pizza 1477578287");
		TreeMap<Long, TreeSet> map = new TreeMap<>();
		map.put((long) 1477578287, new TreeSet(Arrays.asList("Pizza")));
		map.put((long) 1477578587, new TreeSet(Arrays.asList("Delight")));
		map.put((long) 1477578298, new TreeSet(Arrays.asList("Veggie")));
		map.put((long) 1477578487, new TreeSet(Arrays.asList("Chicken")));
		map.put((long) 1477578387, new TreeSet(Arrays.asList("Mushroom")));
		Assert.assertEquals(map, dataProcessing.processReadData(list));
	}


	// Reading Data with same name
	@Test
	public void processDataFromList_SameName()
	{
		List<String> list = new ArrayList<>();
		list.add("order time");
		list.add("Pizza 1477578287");
		list.add("Pizza 1477578298");
		list.add("Pizza 1477578387");
		list.add("Pizza 1477578487");
		list.add("Pizza 1477578587");
		TreeMap<Long, TreeSet> map = new TreeMap<>();
		map.put((long) 1477578287,  new TreeSet(Arrays.asList("Pizza")));
		map.put((long) 1477578298,  new TreeSet(Arrays.asList("Pizza")));
		map.put((long) 1477578387,  new TreeSet(Arrays.asList("Pizza")));
		map.put((long) 1477578487,  new TreeSet(Arrays.asList("Pizza")));
		map.put((long) 1477578587,  new TreeSet(Arrays.asList("Pizza")));
		Assert.assertEquals(map, dataProcessing.processReadData(list));
	}

	// Reading Data with epoch name
	@Test
	public void processDataFromList_SameEpoch()
	{
		List<String> list = new ArrayList<>();
		list.add("order time");
		list.add("Pizza 1477578287");
		list.add("Burger 1477578287");
		list.add("Milk 1477578287");
		list.add("Dhol 1477578287");
        TreeMap<Long, TreeSet> map = new TreeMap<>();
        TreeSet<String> set= new TreeSet<>();
        set.add("Pizza");
        set.add("Dhol");
        set.add("Burger");
        set.add("Milk");
        map.put((long) 1477578287, set);
		Assert.assertEquals(map, dataProcessing.processReadData(list));
	}
}
