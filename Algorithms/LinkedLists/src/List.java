public class List<T> {
    public List( T value ) { data = value; }
    public List<T> next() { return next; }
    public T value() { return data; }
    public void setNext( List<T> elem ) { next = elem; }
    public void setValue( T value ) { data = value; }
    private List<T> next;  private T data;

    public List<T> insertInFront( List<T> list, T data ){
        List<T> l = new List<T>( data );
        l.setNext( list );
        return l;
    }

    public List<T> find( List<T> head, T data ){
        List<T> elem = head;
        while( elem != null && elem.value() != data ){
            elem = elem.next();
        }
        return elem;
    }


    public static void main(String[] args){

    }
}


