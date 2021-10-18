package datastructures;




public class Set{

    private static Object[] contents;

    public static Object[] create(){
        contents = new Object[0];
        return contents;
    }

    public static Object[] createWithCapacity(int capacity){
        contents = new Object[capacity];
        return contents;
    }


    public static int capacity(){
        return contents.length;
    }

    public static Object[] add(Object obj){
        int capacity = contents.length+1;
        int i = 0;
        Object[] newContents = new Object[capacity];
        while(i<contents.length){
            newContents[i] = contents[i];
            i++;
        }
        newContents[i] = obj;
        contents = newContents;
        return contents;
    }

    public static Object[] remove(Object obj){
        int capacity = contents.length-1;
        int i = 0;
        Object[] newContents = new Object[capacity];
        while(i<contents.length){
            if(contents[i] != obj) {
                newContents[i] = contents[i];
            }
            i++;
        }
        contents = newContents;
        return contents;
    }

}
