package hashtab;

/**
 * @author 张旭东
 * @version 1.0.0
 * @function
 * @date 2020年04月23日 13:23:00
 * @place 公司
 * @copyright 张旭东
 */
public class Emp {
    private int id;
    private String name;
    private Emp next;

    public Emp(int id, String name){
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Emp getNext() {
        return next;
    }

    public void setNext(Emp next) {
        this.next = next;
    }
}
