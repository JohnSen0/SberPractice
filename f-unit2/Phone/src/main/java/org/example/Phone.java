package org.example;

public class Phone {

    public Phone (String number, String model, int weight){
        this.number = number;
        this.model = model;
        this.weight = weight;
        this.is_weight_set = true;
    }

    public Phone (String number, String model){
        this.number = number;
        this.model = model;
    }

    public String getNumber (){
        return this.number;
    }

    public String toString() {
        if (is_weight_set){
            return "Телефон { номер - " + this.number + " // модель - " + this.model + " // вес - " + this.weight + " }";
        }
        else {
            return "Телефон { номер - " + this.number + " // модель - " + this.model + " }";
        }
    }

    public void reciveCall (String name) {
        System.out.printf("Звонит %s%n", name);
    }

    public void reciveCall (String name, String number) {
        System.out.printf("Звонит %s - %s%n", name, number);
    }

    public void sendMessage (String[] numbers){
        System.out.println("Отправка сообщения следующим номерам:");
        for (String number : numbers){
            System.out.println(number);
        }
    }

    private String number;
    private String model;
    private int weight;
    private boolean is_weight_set = false;
}

class Main{
    public static void main(String[] args){
        Phone phone1 = new Phone("+79773213450", "Vivo", 500);
        Phone phone2 = new Phone("+79999999999", "Xiaomi");

        System.out.println(phone1.getNumber());
        System.out.println(phone2.toString());

        phone1.reciveCall("Джон");
        phone2.reciveCall("Артур", "+71231231231");

        String[] numbers = {phone1.getNumber(), phone2.getNumber(), "+79111234567"};

        phone1.sendMessage(numbers);
    }
}