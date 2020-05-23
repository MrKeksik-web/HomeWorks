package FourthHomeWorks.First.changeableCollection.Tests;

import FourthHomeWorks.First.changeableCollection.changeableCollection;
import FourthHomeWorks.First.changeableCollection.changeableCollectionIterator;
import org.junit.Assert;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

public class changeableCollectionIteratorTest {

    @Test
    public void iterator() {
        changeableCollection collection = new changeableCollection();
        Iterator expected = collection.iterator();
        Iterator actual = new changeableCollectionIterator(collection.getArr(),collection.size());

        Assert.assertEquals(expected.getClass(),actual.getClass());
    }
}