package Exercise_3;

import java.util.ArrayList;

/**
 * Created by Sean Emerson on 04-04-2016.
 */
public class GenListX_V2 {

    ArrayList<Object> list;

public GenListX_V2 (){

    list = new ArrayList<>();

}

    public void Add(Object o){
        list.add(o);
    }

    public int size(){
        return list.size();
    }

    public Object getObject(int index) throws IndexOutOfBoundsException{
        if (index < 0 || index > list.size()){
        throw new IndexOutOfBoundsException("Error (get): Invalid index: " + index);
        }

        return list.get(index);
    }

    public void addAtIndex(int index, Object o)throws IndexOutOfBoundsException{

        if (index < 0 || index > list.size()){
            throw new IndexOutOfBoundsException("Error (add): Invalid index: " + index);
        }
        else
        list.add(index, o);
    }

    public void remove(int index)throws IndexOutOfBoundsException{

        if (index < 0 || index > list.size()){
            throw new IndexOutOfBoundsException("Error (add): Invalid index: " + index);
        }
        list.remove(index);
    }

}
