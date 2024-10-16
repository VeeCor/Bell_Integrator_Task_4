import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        String chosenVar;
        Basket basket = new Basket();
        do{
            List<String> products = new ArrayList<>(basket.getProducts());
            Scanner sc = new Scanner(System.in);
            System.out.println("""
                    
                    1. Список товаров в корзине
                    2. Добавить товар в корзину
                    3. Удалить товар из корзины
                    4. Изменить количество товара в корзине
                    5. Очистить корзину
                    6. Завершить программу
                    """);
            System.out.print("Укажите номер пункта: ");
            chosenVar = sc.nextLine();
            switch (chosenVar){
                case "1":
                    try{
                        if (products.isEmpty()){
                            System.out.println("\nКорзина пуста!");
                        }else{
                            System.out.println("\nТовары" + "\t" + "Количество");
                            for (String product : products){
                                int quantity = basket.getProductQuantity(product);
                                System.out.println(product + "\t" + quantity);
                            }
                        }
                        break;
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                case "2":
                    try {
                        System.out.print("Введите название товара: ");
                        String product2 = sc.nextLine();
                        System.out.print("Введите количество: ");
                        int quantity2 = sc.nextInt();
                        basket.addProduct(product2, quantity2);
                        System.out.println("\nТовар добавлен в корзину!");
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case "3":
                    System.out.print("Введите название товара, который желаете удалить из корзины: ");
                    String product3 = sc.nextLine();
                    if(products.contains(product3)){
                        try{
                            basket.removeProduct(product3);
                            System.out.println("\nТовар удален из корзины!");
                        }catch (Exception e){
                            System.out.println(e.getMessage());
                        }
                    }else {
                        System.out.println("\nТовар не найден!");
                    }
                    break;
                case "4":
                    System.out.print("Введите название товара: ");
                    String product4 = sc.nextLine();
                    if(products.contains(product4)) {
                        System.out.print("Введите новое количество: ");
                        int quantity3 = sc.nextInt();
                        try {
                            basket.updateProductQuantity(product4, quantity3);
                            System.out.println("\nКоличество товара " + product4 + " в корзине изменено на " + quantity3 + "!");
                        }catch (Exception e){
                            System.out.println(e.getMessage());
                        }
                    }else {
                        System.out.println("\nТовар не найден!");
                    }
                    break;
                case "5":
                    try {
                        basket.clear();
                        System.out.println("\nКорзина очищена!");
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case "6":
                    break;
                default:
                    System.out.println("\nКоманда не найдена!");
                    break;
            }
        }while(!chosenVar.equals("6"));
    }
}


