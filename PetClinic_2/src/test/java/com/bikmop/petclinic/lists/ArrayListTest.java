package com.bikmop.petclinic.lists;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

import static org.junit.Assert.*;

//The same tests as for ArrayList
public class ArrayListTest {
    
    //TestGet
    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetEmpty() throws Exception {
        ArrayList<Object> list = new ArrayList<>();

        list.get(0);
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void testGetNegative() throws Exception {
        ArrayList<Object> list = new ArrayList<>();
        list.add(5);

        list.get(-5);
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void testGetMoreThanLength() throws Exception {
        ArrayList<Object> list = new ArrayList<>();
        list.add(0);
        list.add(1);
        list.add(2);

        list.get(3);
    }

    @Test
    public void testGetAfterAddOne() throws Exception {
        ArrayList<String> list = new ArrayList<>();
        list.add("test");
        String result = list.get(0);

        assertEquals("test", result);
    }

    @Test
    public void testGetAfterAddSome() throws Exception {
        ArrayList<String> list = new ArrayList<>();
        list.add("test01");
        list.add("test02");
        list.add("test03");
        String result = list.get(0);

        assertEquals("test01", result);
    }

    @Test
    public void testGetAfterAddChangeInitialLength() throws Exception {
        ArrayList<Object> list = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            list.add(i);
        }

        assertEquals(0, list.get(0));
        assertEquals(5, list.get(5));
        assertEquals(11, list.get(11));
    }

    @Test
    public void testGetAfterAddAndRemove01() throws Exception {
        ArrayList<String> list = new ArrayList<>();
        list.add("test0");
        list.add("test1");
        list.remove(0);
        String result = list.get(0);

        assertEquals("test1", result);
    }

    @Test
    public void testGetAfterAddAndRemove02() throws Exception {
        ArrayList<String> list = new ArrayList<>();
        list.add("test0");
        list.add("test1");
        list.remove(1);
        String result = list.get(0);

        assertEquals("test0", result);
    }

    @Test
    public void testGetAfterAddAndRemove03() throws Exception {
        ArrayList<String> list = new ArrayList<>();
        list.add("test0");
        list.add("test1");
        list.remove("test0");
        String result = list.get(0);

        assertEquals("test1", result);
    }


    //TestSize
    @Test
    public void testSizeEmpty() throws Exception {
        ArrayList<Object> list = new ArrayList<>();

        assertEquals(list.size(), 0);
    }

    @Test
    public void testSizeAddOne() throws Exception {
        ArrayList<Object> list = new ArrayList<>();
        list.add(0);

        assertEquals(list.size(), 1);
    }

    @Test
    public void testSizeAddSome() throws Exception {
        ArrayList<Object> list = new ArrayList<>();
        list.add(0);
        list.add("test");
        list.add(10000L);

        assertEquals(list.size(), 3);
    }

    @Test
    public void testSizeAddIncreaseLength() throws Exception {
        ArrayList<Object> list = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            list.add(i);
        }

        assertEquals(list.size(), 12);
    }

    @Test
    public void testSizeAddAndRemove01() throws Exception {
        ArrayList<Object> list = new ArrayList<>();
        list.add(0);
        list.remove(0);

        assertEquals(list.size(), 0);
    }

    @Test
    public void testSizeAddAndRemove02() throws Exception {
        ArrayList<Object> list = new ArrayList<>();
        list.add("test");
        list.add("test");
        list.remove("test");

        assertEquals(list.size(), 1);
    }

    @Test
    public void testSizeAddAndRemove03() throws Exception {
        ArrayList<Object> list = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            list.add(i);
        }

        assertEquals(list.size(), 12);

        list.remove(0);
        list.remove(0);
        list.remove(0);

        assertEquals(list.size(), 9);
    }


    //TestIsEmpty
    @Test
    public void testIsEmptyTrue() throws Exception {
        ArrayList<Object> list = new ArrayList<>();
        assertTrue(list.isEmpty());
    }

    @Test
    public void testIsEmptyFalse() throws Exception {
        ArrayList<Object> list = new ArrayList<>();
        list.add("");
        assertFalse(list.isEmpty());
    }

    @Test
    public void testIsEmptyTrueAddAndRemove() throws Exception {
        ArrayList<Object> list = new ArrayList<>();
        list.add("");
        list.remove("");
        assertTrue(list.isEmpty());
    }

    @Test
    public void testIsEmptyTrueIncreaseLength() throws Exception {
        ArrayList<Integer> list = new ArrayList<>();

        //Change inner array default length
        for (int i = 0; i < 12; i++) {
            list.add(i);
        }
        for (int i = 0; i < 12; i++) {
            list.remove(Integer.valueOf(i));
        }
        assertTrue(list.isEmpty());
    }


    //TestClear
    @Test
    public void testClearEmpty() throws Exception {
        ArrayList<Object> list = new ArrayList<>();
        list.clear();
        assertTrue(list.isEmpty());
    }

    @Test
    public void testClearAdd() throws Exception {
        ArrayList<Object> list = new ArrayList<>();
        list.add(new Object());
        assertFalse(list.isEmpty());
        list.clear();
        assertTrue(list.isEmpty());
    }

    @Test
    public void testClearAddNull() throws Exception {
        ArrayList<Object> list = new ArrayList<>();
        list.add(null);
        assertFalse(list.isEmpty());
        list.clear();
        assertTrue(list.isEmpty());
    }

    @Test
    public void testClearIncreaseLength() throws Exception {
        ArrayList<Object> list = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            list.add(i);
        }
        assertFalse(list.isEmpty());
        list.clear();
        assertTrue(list.isEmpty());
    }


    //TestAdd
    @Test
    public void testAdd01() throws Exception {
        ArrayList<Object> list = new ArrayList<>();
        assertTrue(list.add(0));
    }

    @Test
    public void testAdd02() throws Exception {
        ArrayList<Object> list = new ArrayList<>();
        assertTrue(list.add(0));
        assertTrue(list.add(1));
        assertEquals(0, list.get(0));
    }


    //TestAddTo
    @Test (expected = IndexOutOfBoundsException.class)
    public void testAddToOutOfBound01() throws Exception {
        ArrayList<String> list = new ArrayList<>();
        list.add(1, "test");
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void testAddToOutOfBound02() throws Exception {
        ArrayList<String> list = new ArrayList<>();
        list.add(-1, "test");
    }

    @Test
    public void testAddTo() throws Exception {
        ArrayList<String> list = new ArrayList<>();
        list.add("test00");
        list.add("test01");
        list.add("test02");
        list.add("test03");

        list.add(1, "Added by index.");

        assertEquals("Added by index.", list.get(1));
        assertEquals("test01", list.get(2));
        assertEquals("test02", list.get(3));
        assertEquals("test03", list.get(4));
        assertEquals(5, list.size());
    }

    @Test
    public void testAddToIncreaseLength() throws Exception {
        ArrayList<String> list = new ArrayList<>();
        list.add("test00");
        list.add("test01");
        list.add("test02");
        list.add("test03");

        for (int i = 0; i < 12; i++) {
            list.add(1, "Added by index.");
        }

        assertEquals(16, list.size());
    }

    @Test
    public void testAddToEnd() throws Exception {
        ArrayList<String> list = new ArrayList<>();
        list.add("test00");
        list.add("test01");
        list.add("test02");
        list.add("test03");

        list.add(4, "test04");

        assertEquals("test03", list.get(3));
        assertEquals("test04", list.get(4));
    }

    @Test
    public void testAddToBegin() throws Exception {
        ArrayList<String> list = new ArrayList<>();
        list.add("test00");
        list.add("test01");
        list.add("test02");
        list.add("test03");

        list.add(0, "test04");

        assertEquals("test00", list.get(1));
        assertEquals("test04", list.get(0));
    }


    //TestContains
    @Test
    public void testContainsEmpty() throws Exception {
        ArrayList<String> list = new ArrayList<>();
        assertFalse(list.contains(""));
    }

    @Test
    public void testContainsFalse() throws Exception {
        ArrayList<Object> list = new ArrayList<>();
        list.add(1);
        assertFalse(list.contains(""));
    }

    @Test
    public void testContainsNullFalse() throws Exception {
        ArrayList<Object> list = new ArrayList<>();
        list.add(1);
        assertFalse(list.contains(null));
    }

    @Test
    public void testContainsTrue() throws Exception {
        ArrayList<Object> list = new ArrayList<>();
        list.add(1);
        assertTrue(list.contains(1));
    }

    @Test
    public void testContainsNull() throws Exception {
        ArrayList<Object> list = new ArrayList<>();
        list.add(null);
        assertTrue(list.contains(null));
    }


    //TestRemoveByElement
    @Test
    public void testRemoveNull() throws Exception {
        ArrayList<Object> list = new ArrayList<>();
        list.add(null);
        assertTrue(list.remove(null));
        assertFalse(list.remove(null));
    }

    @Test
    public void testRemoveElement() throws Exception {
        ArrayList<Object> list = new ArrayList<>();
        list.add("test");
        assertTrue(list.remove("test"));
        assertFalse(list.remove("test"));
    }


    //TestRemoveByIndex
    @Test
    public void testRemoveNullByIndex() throws Exception {
        ArrayList<Object> list = new ArrayList<>();
        list.add(null);
        assertEquals(null, list.remove(0));
    }

    @Test
    public void testRemoveElementByIndex() throws Exception {
        ArrayList<Object> list = new ArrayList<>();
        list.add("test");
        assertEquals("test", list.remove(0));
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void testRemoveFromEmpty() throws Exception {
        ArrayList<Object> list = new ArrayList<>();
        list.remove(0);
    }

    @Test
    public void testRemoveLot() throws Exception {
        ArrayList<Object> list = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            list.add(i);
        }

        for (int i = 0; i < 12; i++) {
            list.remove(0);
            assertEquals(11-i, list.size());
        }
    }


    //TestNullList
    @Test (expected = NullPointerException.class)
    public void testNullListGet() throws Exception {
        ArrayList<Object> list = null;
        list.get(0);
    }

    @Test (expected = NullPointerException.class)
    public void testNullListRemove() throws Exception {
        ArrayList<Object> list = null;
        list.remove(0);
    }

    @Test (expected = NullPointerException.class)
    public void testNullListIsEmpty() throws Exception {
        ArrayList<Object> list = null;
        list.isEmpty();
    }


    //TestSet
    @Test (expected = IndexOutOfBoundsException.class)
    public void testSetEmpty() throws Exception {
        ArrayList<Object> list = new ArrayList<>();

        list.set(0, "test");
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void testSetNegative() throws Exception {
        ArrayList<Object> list = new ArrayList<>();
        list.add(5);

        list.set(-5, "test");
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void testSetMoreThanLength() throws Exception {
        ArrayList<Object> list = new ArrayList<>();
        list.add(0);
        list.add(1);
        list.add(2);

        list.set(3, "test");
    }

    @Test
    public void testSet01() throws Exception {
        ArrayList<String> list = new ArrayList<>();
        list.add("test01");

        assertEquals("test01", list.set(0, "test02"));
        assertEquals("test02", list.get(0));
    }

    @Test
    public void testSet02() throws Exception {
        ArrayList<String> list = new ArrayList<>();
        list.add("test01");
        list.add("test02");
        list.add("test03");
        list.set(1, "test04");
        list.set(1, "test05");

        assertEquals("test05", list.set(1, "test06"));
        assertEquals("test06", list.get(1));
    }

    @Test
    public void testSet03() throws Exception {
        ArrayList<Object> list = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            list.add(i);
        }
        list.set(0, "test00");
        list.set(5, "test05");
        list.set(11, "test11");

        assertEquals("test00", list.get(0));
        assertEquals("test05", list.get(5));
        assertEquals("test11", list.get(11));
    }
    
    
    //TestIterator
    @Test
    public void testIterator() throws Exception {
        ArrayList<Object> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            list.add(i);
        }

        Iterator iterator = list.iterator();

        assertEquals(0, iterator.next());
        assertEquals(1, iterator.next());
        assertEquals(2, iterator.next());
    }


    //TestListIterator
    @Test
    public void testListIterator() throws Exception {
        ArrayList<Object> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            list.add(i);
        }

        ListIterator iterator = list.listIterator();

        assertEquals(0, iterator.next());
        assertEquals(1, iterator.next());
        assertEquals(2, iterator.next());
        assertEquals(2, iterator.previous());
        assertEquals(1, iterator.previous());
        assertEquals(0, iterator.previous());
    }

}

