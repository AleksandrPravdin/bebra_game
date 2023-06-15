package projects.myApplication;

public class GameLogic {
    private int px;
    private int py;
    private boolean playerOnCoffee = false;

    public boolean isPlayerOnCoffee() {
        return playerOnCoffee;
    }

    public int getPx() {
        return px;
    }

    public int getPy() {
        return py;
    }

    public int[][] move(int[][] arr, int playerY, int playerX, boolean playerOnCoffeeW, String move) {
        playerOnCoffee = playerOnCoffeeW;
        px = playerX;
        py = playerY;
        switch (move) {
            case "LEFT":
                if (arr[playerY][playerX - 1] == 0) {
                    if (playerOnCoffee) {
                        arr[playerY][playerX] = 4;
                        playerOnCoffee = false;
                    } else {
                        arr[playerY][playerX] = 0;
                    }
                    arr[playerY][playerX - 1] = 2;
                    px = playerX - 1;
                } else if (arr[playerY][playerX - 1] == 4) {
                    if (playerOnCoffee) {
                        arr[playerY][playerX] = 4;
                    } else {
                        arr[playerY][playerX] = 0;
                    }
                    playerOnCoffee = true;
                    arr[playerY][playerX - 1] = 2;
                    px = playerX - 1;
                } else if (arr[playerY][playerX - 1] == 3 && arr[playerY][playerX - 2] == 0) {
                    if (playerOnCoffee) {
                        arr[playerY][playerX] = 4;
                        playerOnCoffee = false;
                    } else {
                        arr[playerY][playerX] = 0;
                    }
                    arr[playerY][playerX - 1] = 2;
                    arr[playerY][playerX - 2] = 3;
                    px = playerX - 1;
                } else if (arr[playerY][playerX - 1] == 3 && arr[playerY][playerX - 2] == 4) {
                    if (playerOnCoffee) {
                        arr[playerY][playerX] = 4;
                        playerOnCoffee = false;
                    } else {
                        arr[playerY][playerX] = 0;
                    }
                    arr[playerY][playerX - 1] = 2;
                    arr[playerY][playerX - 2] = 5;
                    px = playerX - 1;
                } else if (arr[playerY][playerX - 1] == 5 && arr[playerY][playerX - 2] == 0) {
                    if (playerOnCoffee) {
                        arr[playerY][playerX] = 4;
                    } else {
                        arr[playerY][playerX] = 0;
                    }
                    playerOnCoffee = true;
                    arr[playerY][playerX - 1] = 2;
                    arr[playerY][playerX - 2] = 3;
                    px = playerX - 1;
                } else if (arr[playerY][playerX - 1] == 5 && arr[playerY][playerX - 2] == 4) {
                    if (playerOnCoffee) {
                        arr[playerY][playerX] = 4;
                    } else {
                        arr[playerY][playerX] = 0;
                    }
                    playerOnCoffee = true;
                    arr[playerY][playerX - 1] = 2;
                    arr[playerY][playerX - 2] = 5;
                    px = playerX - 1;
                }
                break;
            case "RIGHT":
                if (arr[playerY][playerX + 1] == 0) {
                    if (playerOnCoffee) {
                        arr[playerY][playerX] = 4;
                        playerOnCoffee = false;
                    } else {
                        arr[playerY][playerX] = 0;
                    }
                    arr[playerY][playerX + 1] = 2;
                    px = playerX + 1;
                } else if (arr[playerY][playerX + 1] == 4) {
                    if (playerOnCoffee) {
                        arr[playerY][playerX] = 4;
                    } else {
                        arr[playerY][playerX] = 0;
                    }
                    playerOnCoffee = true;
                    arr[playerY][playerX + 1] = 2;
                    px = playerX + 1;
                } else if (arr[playerY][playerX + 1] == 3 && arr[playerY][playerX + 2] == 0) {
                    if (playerOnCoffee) {
                        arr[playerY][playerX] = 4;
                        playerOnCoffee = false;
                    } else {
                        arr[playerY][playerX] = 0;
                    }
                    arr[playerY][playerX + 1] = 2;
                    arr[playerY][playerX + 2] = 3;
                    px = playerX + 1;
                } else if (arr[playerY][playerX + 1] == 3 && arr[playerY][playerX + 2] == 4) {
                    if (playerOnCoffee) {
                        arr[playerY][playerX] = 4;
                        playerOnCoffee = false;
                    } else {
                        arr[playerY][playerX] = 0;
                    }
                    arr[playerY][playerX + 1] = 2;
                    arr[playerY][playerX + 2] = 5;
                    px = playerX + 1;
                } else if (arr[playerY][playerX + 1] == 5 && arr[playerY][playerX + 2] == 0) {
                    if (playerOnCoffee) {
                        arr[playerY][playerX] = 4;
                    } else {
                        arr[playerY][playerX] = 0;
                    }
                    playerOnCoffee = true;
                    arr[playerY][playerX + 1] = 2;
                    arr[playerY][playerX + 2] = 3;
                    px = playerX + 1;
                } else if (arr[playerY][playerX + 1] == 5 && arr[playerY][playerX + 2] == 4) {
                    if (playerOnCoffee) {
                        arr[playerY][playerX] = 4;
                    } else {
                        arr[playerY][playerX] = 0;
                    }
                    playerOnCoffee = true;
                    arr[playerY][playerX + 1] = 2;
                    arr[playerY][playerX + 2] = 5;
                    px = playerX + 1;
                }
                break;
            case "UP":
                if (arr[playerY - 1][playerX] == 0) {
                    if (playerOnCoffee) {
                        arr[playerY][playerX] = 4;
                        playerOnCoffee = false;
                    } else {
                        arr[playerY][playerX] = 0;
                    }
                    arr[playerY - 1][playerX] = 2;
                    py = playerY - 1;
                } else if (arr[playerY - 1][playerX] == 4) {
                    if (playerOnCoffee) {
                        arr[playerY][playerX] = 4;
                    } else {
                        arr[playerY][playerX] = 0;
                    }
                    playerOnCoffee = true;
                    arr[playerY - 1][playerX] = 2;
                    py = playerY - 1;
                } else if (arr[playerY - 1][playerX] == 3 && arr[playerY - 2][playerX] == 0) {
                    if (playerOnCoffee) {
                        arr[playerY][playerX] = 4;
                        playerOnCoffee = false;
                    } else {
                        arr[playerY][playerX] = 0;
                    }
                    arr[playerY - 1][playerX] = 2;
                    arr[playerY - 2][playerX] = 3;
                    py = playerY - 1;
                } else if (arr[playerY - 1][playerX] == 3 && arr[playerY - 2][playerX] == 4) {
                    if (playerOnCoffee) {
                        arr[playerY][playerX] = 4;
                        playerOnCoffee = false;
                    } else {
                        arr[playerY][playerX] = 0;
                    }
                    arr[playerY - 1][playerX] = 2;
                    arr[playerY - 2][playerX] = 5;
                    py = playerY - 1;
                } else if (arr[playerY - 1][playerX] == 5 && arr[playerY - 2][playerX] == 0) {
                    if (playerOnCoffee) {
                        arr[playerY][playerX] = 4;
                    } else {
                        arr[playerY][playerX] = 0;
                    }
                    playerOnCoffee = true;
                    arr[playerY - 1][playerX] = 2;
                    arr[playerY - 2][playerX] = 3;
                    py = playerY - 1;
                } else if (arr[playerY - 1][playerX] == 5 && arr[playerY - 2][playerX] == 4) {
                    if (playerOnCoffee) {
                        arr[playerY][playerX] = 4;
                    } else {
                        arr[playerY][playerX] = 0;
                    }
                    playerOnCoffee = true;
                    arr[playerY - 1][playerX] = 2;
                    arr[playerY - 2][playerX] = 5;
                    py = playerY - 1;
                }
                break;
            case "DOWN":
                if (arr[playerY + 1][playerX] == 0) {
                    if (playerOnCoffee) {
                        arr[playerY][playerX] = 4;
                        playerOnCoffee = false;
                    } else {
                        arr[playerY][playerX] = 0;
                    }
                    arr[playerY + 1][playerX] = 2;
                    py = playerY + 1;
                } else if (arr[playerY + 1][playerX] == 4) {
                    if (playerOnCoffee) {
                        arr[playerY][playerX] = 4;
                    } else {
                        arr[playerY][playerX] = 0;
                    }
                    playerOnCoffee = true;
                    arr[playerY + 1][playerX] = 2;
                    py = playerY + 1;
                } else if (arr[playerY + 1][playerX] == 3 && arr[playerY + 2][playerX] == 0) {
                    if (playerOnCoffee) {
                        arr[playerY][playerX] = 4;
                        playerOnCoffee = false;
                    } else {
                        arr[playerY][playerX] = 0;
                    }
                    arr[playerY + 1][playerX] = 2;
                    arr[playerY + 2][playerX] = 3;
                    py = playerY + 1;
                } else if (arr[playerY + 1][playerX] == 3 && arr[playerY + 2][playerX] == 4) {
                    if (playerOnCoffee) {
                        arr[playerY][playerX] = 4;
                        playerOnCoffee = false;
                    } else {
                        arr[playerY][playerX] = 0;
                    }
                    arr[playerY + 1][playerX] = 2;
                    arr[playerY + 2][playerX] = 5;
                    py = playerY + 1;
                } else if (arr[playerY + 1][playerX] == 5 && arr[playerY + 2][playerX] == 0) {
                    if (playerOnCoffee) {
                        arr[playerY][playerX] = 4;
                    } else {
                        arr[playerY][playerX] = 0;
                    }
                    playerOnCoffee = true;
                    arr[playerY + 1][playerX] = 2;
                    arr[playerY + 2][playerX] = 3;
                    py = playerY + 1;
                } else if (arr[playerY + 1][playerX] == 5 && arr[playerY + 2][playerX] == 4) {
                    if (playerOnCoffee) {
                        arr[playerY][playerX] = 4;
                    } else {
                        arr[playerY][playerX] = 0;
                    }
                    playerOnCoffee = true;
                    arr[playerY + 1][playerX] = 2;
                    arr[playerY + 2][playerX] = 5;
                    py = playerY + 1;
                }
                break;
        }
        return arr;
    }

    public boolean winGame(int[][] arr, int[][] coordinateCoffee) {
        boolean win = true;
        for (int i = 0; i < coordinateCoffee.length; i++) {
            if (arr[coordinateCoffee[i][0]][coordinateCoffee[i][1]] != 5) {
                win = false;
            }
        }
        return win;
    }
}
