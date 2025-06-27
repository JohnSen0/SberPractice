package org.example;

enum SIZE {SMALL, MEDIUM, BIG};

public class PizzaOrder {

    public PizzaOrder(SIZE size, String name, boolean is_sauce_needed, String address){
        this.size = size;
        this.name = name;
        this.is_sauce_needed = is_sauce_needed;
        this.address = address;
        this.is_taken = false;
    }

    // Геттеры
    public String getSize() {
        return switch (this.size) {
            case SMALL -> "Маленькая";
            case MEDIUM -> "Средняя";
            case BIG -> "Большая";
        };
    }
    public String getName(){
        return this.name;
    }
    public boolean getSauceNeeded(){
        return this.is_sauce_needed;
    }
    public String getSauceStr(){
        if (is_sauce_needed){
            return "c соусом";
        }
        else {
            return "без соуса";
        }
    }
    public String getAddress(){
        return this.address;
    }

    // Сеттеры
    public void setSize(SIZE size) {
        this.size = size;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setSauceNeeded(boolean is_sauce_needed) {
        this.is_sauce_needed = is_sauce_needed;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    // Методы
    public void order(){
        if(!this.is_taken){
            System.out.printf("Заказ принят. %s пицца «%s» %s на адрес %s.",
                    getSize(),
                    getName(),
                    getSauceStr(),
                    getAddress());
            this.is_taken = true;
        }
        else {
            System.out.println("Заказ уже принят");
        }
    }

    public void cancel(){
        if (this.is_taken){
            System.out.println("Заказ отменен");
            this.is_taken = false;
        }
        else {
            System.out.println("Заказ не был принят");
        }
    }

    public String toString(){
        return "Информация о заказе:\n" +
                "- Размер: " + getSize() + "\n" +
                "- Название: " + this.name + "\n" +
                "- Адрес: " + this.address + "\n";
    }


    private SIZE size;
    private String name;
    private boolean is_sauce_needed;
    private String address;
    private boolean is_taken;
}

class Main {
    public static void main(String[] args) {
        // Создаем новый заказ пиццы
        PizzaOrder order1 = new PizzaOrder(SIZE.MEDIUM, "Пепперони", true, "ул. Пиццная, д. 5");

        System.out.println(order1);

        order1.order();
        order1.order();

        System.out.println("\nОтменяем заказ:");
        order1.cancel();

        System.out.println("\nПовторно отменяем заказ:");
        order1.cancel();

        System.out.println("\nМеняем параметры заказа:");
        order1.setName("Гавайская");
        order1.setSize(SIZE.BIG);
        order1.setSauceNeeded(false);
        order1.setAddress("ул. Новая, д. 10");

        System.out.println("\nОбновленная информация о заказе:");
        System.out.println(order1);

        System.out.println("\nПринимаем изменённый заказ:");
        order1.order();
    }
}