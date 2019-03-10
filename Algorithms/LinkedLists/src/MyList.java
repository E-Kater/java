

public class MyList<T> {
    public MyList( T value ) { data = value; } // next automatically = null
    public MyList<T> next() { return next; }
    public void setNext( MyList<T> elem ) { next = elem; }
    public void setValue( T value ) { data = value; }
    private MyList<T> next;
    private T data;
    public T getData() {
        return data;
    }
    public MyList<T> insertInFront( T data ){
        MyList<T> l = new MyList<T>( data );
        l.setNext( this );
       return l;
    }


    public MyList<T> insertInEnd(  T data ){
        MyList<T> l = new MyList<T>( data );
        MyList<T> ths = this;
        while (ths.next() != null){
            ths = ths.next();
        }

        ths.setNext( l );
        return this;
    }

    public MyList<T> find( MyList<T> head, T data ){
        MyList<T> elem = head;
        while( elem != null && elem.getData() != data ){
            elem = elem.next();
        }
        return elem;
    }

    public  String getListAsString(){
        StringBuilder res = new StringBuilder();
        MyList<T> temp = this;
        while (temp != null){
            res.append(temp.getData().toString());
            temp = temp.next();
        }
        return res.toString();
}

    public static void main(String[] args){

    }

}