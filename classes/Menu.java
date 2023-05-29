package classes;

public class Menu {
    public void startMenu() {
        System.out.println("===== SEJA BEM VINDO, AVENTUREIRO !!! =====");
        System.out.println("Escolha uma opção:");
        System.out.println("1. Iniciar Aventura");
        System.out.println("2. Sair do Jogo");
    }

    public void gameOverScreen() {
        System.out.println("======== GAME OVER ========");
        System.out.println("1 - RESTART  | 2 - EXIT");
    }

    public void gameOverConsfirm() {
        System.out.println("======== DO YOU WISH TO LEAVE ? ========");
        System.out.println("1 - SIM  | 2 - NAO");
    }

    
}
