package classes;

public class Menu {
    public void startMenu() {
        System.out.println("===== WELCOME, ADVENTURER !!! =====");
        System.out.println("<< Chose an option >>");
        System.out.println("1. Start Adventure");
        System.out.println("2. Exit");
    }

    public void gameOverScreen() {
        System.out.println("======== GAME OVER ========");
        System.out.println("1 - RESTART  | 2 - EXIT");
    }

    public void gameOverConfirm() {
        System.out.println("======== DO YOU WISH TO LEAVE ? ========");
        System.out.println("1 - YES  | 2 - NO");
    }

    
}
