package hello.hello_spring.singletone;

public class StatefulService {
    private int price;

    public void order(String name ,int price) {
        System.out.println("name ="+ name + " price="+price);
        this.price = price; // 문제가 되는 기분
        // 싱글톤은 무상태로 설계해야 됨
        // 공유되지 않는 지역변수를 쓰는게 남
    }

    public int getPrice() {
        return price;
    }
}
