package FourthHomeWorks.First.changeableCollection.Tests;

import FourthHomeWorks.First.changeableCollection.changeableCollection;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class changeableCollectionEqualsTest {

    @Test
    public void testEqualsTrue() {
        changeableCollection<Integer> coll1 = new changeableCollection<>();
        coll1.add(1);
        changeableCollection<Integer> coll2 = new changeableCollection<>();
        coll2.add(1);
        boolean expected = coll1.equals(coll2);
        boolean actual = true;

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void testEqualsFalse() {
        changeableCollection<Integer> coll1 = new changeableCollection<>();
        coll1.add(1);
        changeableCollection<Integer> coll2 = new changeableCollection<>();
        coll2.add(2);
        boolean expected = coll1.equals(coll2);
        boolean actual = true;

        Assert.assertNotEquals(expected,actual);
    }

    @Test
    public void testEqualsDiffSize() {
        changeableCollection<Integer> coll1 = new changeableCollection<>();
        coll1.add(1);
        changeableCollection<Integer> coll2 = new changeableCollection<>();
        coll2.add(1);
        coll2.add(1);
        boolean expected = coll1.equals(coll2);
        boolean actual = false;

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void testEqualsSizeZero() {
        changeableCollection<Integer> coll1 = new changeableCollection<>();
        changeableCollection<Integer> coll2 = new changeableCollection<>();
        boolean expected = coll1.equals(coll2);
        boolean actual = true;

        Assert.assertEquals(expected,actual);
    }
}