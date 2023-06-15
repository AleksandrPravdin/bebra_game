package projects.myApplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class GameWindow extends AppCompatActivity {
    private final String FILE_NAME = "LEVELS_OPEN";
    Button buttonPlay;
    Button buttonEmoji;
    Button buttonRules;
    Button buttonAuthor;
    Button buttonExit;
    Button buttonPlayLevel1;
    Button buttonPlayLevel2;
    Button buttonPlayLevel3;
    Button buttonPlayLevel4;
    Button buttonPlayLevel5;
    Button buttonPlayLevel6;
    Button buttonPlayLevel7;
    Button buttonPlayLevel8;
    Button buttonPlayLevel9;
    Button buttonPlayLevel10;
    Button buttonLevelsBack;
    Button buttonEmojiBack;
    Button buttonRulesBack;
    Button buttonAuthorBack;
    Button buttonLeft;
    Button buttonRight;
    Button buttonUp;
    Button buttonDown;
    Button buttonSetting;
    Button buttonContinue;
    Button buttonReturn;
    Button buttonMenu;
    Button buttonWinLevel;
    Button buttonSmile;
    Button buttonAngrySmile;
    Button buttonVirusSmile;
    Button buttonClownSmile;
    Button buttonAlienSmile;
    Button buttonDevilSmile;
    Button buttonLinkTG;
    Button buttonLinkVK;
    ImageView[][] imageViewArr = new ImageView[14][8];
    int[][] playFieldArr = new int[14][8];
    int[][] coffeeCoordinate;
    GameLogic gameLogic = new GameLogic();
    int playerX;
    int playerY;
    boolean playerOnCoffee = false;
    String currentLevel;
    Button[] buttonsArr = new Button[10];
    Button[] buttonsEmoji = new Button[6];
    SharedPreferences settings;
    SharedPreferences.Editor editor;
    int[] openLevels = new int[10];
    String currentSmile;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        createMainLayout();
    }

    @SuppressLint("MissingInflatedId")
    private void createMainLayout() {
        setContentView(R.layout.activity_main);
        settings = getSharedPreferences(FILE_NAME, MODE_PRIVATE);
        currentSmile = settings.getString("currentSmile", "smile");

        buttonPlay = findViewById(R.id.buttonPlay);
        buttonPlay.setOnClickListener(v -> createLevelLayout());
        buttonEmoji = findViewById(R.id.buttonEmoji);
        buttonEmoji.setOnClickListener(v -> createEmojiLayout());
        buttonRules = findViewById(R.id.buttonRules);
        buttonRules.setOnClickListener(v -> createRulesLayout());
        buttonAuthor = findViewById(R.id.buttonAboutAuthor);
        buttonAuthor.setOnClickListener(v -> createAuthorLayout());
        buttonExit = findViewById(R.id.buttonExit);
        buttonExit.setOnClickListener(v -> android.os.Process.killProcess(android.os.Process.myPid()));
    }

    private void createLevelLayout() {
        setContentView(R.layout.levels);
        settings = getSharedPreferences(FILE_NAME, MODE_PRIVATE);
        openLevels[0] = (settings.getInt("openLevel_1", 1));
        openLevels[1] = (settings.getInt("openLevel_2", 0));
        openLevels[2] = (settings.getInt("openLevel_3", 0));
        openLevels[3] = (settings.getInt("openLevel_4", 0));
        openLevels[4] = (settings.getInt("openLevel_5", 0));
        openLevels[5] = (settings.getInt("openLevel_6", 0));
        openLevels[6] = (settings.getInt("openLevel_7", 0));
        openLevels[7] = (settings.getInt("openLevel_8", 0));
        openLevels[8] = (settings.getInt("openLevel_9", 0));
        openLevels[9] = (settings.getInt("openLevel_10", 0));

        buttonLevelsBack = findViewById(R.id.buttonLevelsBack);
        buttonLevelsBack.setOnClickListener(v -> createMainLayout());
        buttonPlayLevel1 = findViewById(R.id.buttonLevel1);
        buttonPlayLevel1.setOnClickListener(v -> createPlayFieldLayout("level_1", false));
        buttonsArr[0] = buttonPlayLevel1;
        buttonPlayLevel2 = findViewById(R.id.buttonLevel2);
        buttonPlayLevel2.setOnClickListener(v -> createPlayFieldLayout("level_2", false));
        buttonsArr[1] = buttonPlayLevel2;
        buttonPlayLevel3 = findViewById(R.id.buttonLevel3);
        buttonPlayLevel3.setOnClickListener(v -> createPlayFieldLayout("level_3", false));
        buttonsArr[2] = buttonPlayLevel3;
        buttonPlayLevel4 = findViewById(R.id.buttonLevel4);
        buttonPlayLevel4.setOnClickListener(v -> createPlayFieldLayout("level_4", false));
        buttonsArr[3] = buttonPlayLevel4;
        buttonPlayLevel5 = findViewById(R.id.buttonLevel5);
        buttonPlayLevel5.setOnClickListener(v -> createPlayFieldLayout("level_5", false));
        buttonsArr[4] = buttonPlayLevel5;
        buttonPlayLevel6 = findViewById(R.id.buttonLevel6);
        buttonPlayLevel6.setOnClickListener(v -> createPlayFieldLayout("level_6", false));
        buttonsArr[5] = buttonPlayLevel6;
        buttonPlayLevel7 = findViewById(R.id.buttonLevel7);
        buttonPlayLevel7.setOnClickListener(v -> createPlayFieldLayout("level_7", false));
        buttonsArr[6] = buttonPlayLevel7;
        buttonPlayLevel8 = findViewById(R.id.buttonLevel8);
        buttonPlayLevel8.setOnClickListener(v -> createPlayFieldLayout("level_8", false));
        buttonsArr[7] = buttonPlayLevel8;
        buttonPlayLevel9 = findViewById(R.id.buttonLevel9);
        buttonPlayLevel9.setOnClickListener(v -> createPlayFieldLayout("level_9", false));
        buttonsArr[8] = buttonPlayLevel9;
        buttonPlayLevel10 = findViewById(R.id.buttonLevel10);
        buttonPlayLevel10.setOnClickListener(v -> createPlayFieldLayout("level_10", false));
        buttonsArr[9] = buttonPlayLevel10;

        for (int i = 0; i < buttonsArr.length; i++) {
            switch (openLevels[i]) {
                case 0:
                    buttonsArr[i].setEnabled(false);
                    buttonsArr[i].setTextColor(Color.parseColor("#C0C0C0"));
                    break;
                case 1:
                    buttonsArr[i].setEnabled(true);
                    break;
                case 2:
                    buttonsArr[i].setEnabled(true);
                    buttonsArr[i].setTextColor(Color.parseColor("#FFD700"));
                    break;
            }
        }
    }

    @SuppressLint("MissingInflatedId")
    private void createEmojiLayout() {
        setContentView(R.layout.emoji);
        buttonEmojiBack = findViewById(R.id.buttonEmojiBack);
        buttonEmojiBack.setOnClickListener(v -> createMainLayout());

        buttonSmile = findViewById(R.id.buttonSmile);
        buttonSmile.setOnClickListener(v -> chooseEmoji(0, "smile"));
        buttonAngrySmile = findViewById(R.id.buttonAngrySmile);
        buttonAngrySmile.setOnClickListener(v -> chooseEmoji(1, "angrySmile"));
        buttonAlienSmile = findViewById(R.id.buttonAlienSmile);
        buttonAlienSmile.setOnClickListener(v -> chooseEmoji(2, "alienSmile"));
        buttonVirusSmile = findViewById(R.id.buttonVirusSmile);
        buttonVirusSmile.setOnClickListener(v -> chooseEmoji(3, "virusSmile"));
        buttonClownSmile = findViewById(R.id.buttonClownSmile);
        buttonClownSmile.setOnClickListener(v -> chooseEmoji(4, "clownSmile"));
        buttonDevilSmile = findViewById(R.id.buttonDevilSmile);
        buttonDevilSmile.setOnClickListener(v -> {
            buttonSmile.setBackgroundColor(Color.parseColor("#1E90FF"));
            chooseEmoji(5, "devilSmile");
        });

        buttonsEmoji[0] = buttonSmile;
        buttonsEmoji[1] = buttonAngrySmile;
        buttonsEmoji[2] = buttonAlienSmile;
        buttonsEmoji[3] = buttonVirusSmile;
        buttonsEmoji[4] = buttonClownSmile;
        buttonsEmoji[5] = buttonDevilSmile;

        switch (currentSmile) {
            case "smile":
                buttonSmile.setBackgroundColor(Color.parseColor("#FFD700"));
                buttonSmile.setTextColor(Color.parseColor("#1E90FF"));
                buttonSmile.setText("✔");
                break;
            case "angrySmile":
                buttonAngrySmile.setBackgroundColor(Color.parseColor("#FFD700"));
                buttonAngrySmile.setTextColor(Color.parseColor("#1E90FF"));
                buttonAngrySmile.setText("✔");
                break;
            case "alienSmile":
                buttonAlienSmile.setBackgroundColor(Color.parseColor("#FFD700"));
                buttonAlienSmile.setTextColor(Color.parseColor("#1E90FF"));
                buttonAlienSmile.setText("✔");
                break;
            case "virusSmile":
                buttonVirusSmile.setBackgroundColor(Color.parseColor("#FFD700"));
                buttonVirusSmile.setTextColor(Color.parseColor("#1E90FF"));
                buttonVirusSmile.setText("✔");
                break;
            case "clownSmile":
                buttonClownSmile.setBackgroundColor(Color.parseColor("#FFD700"));
                buttonClownSmile.setTextColor(Color.parseColor("#1E90FF"));
                buttonClownSmile.setText("✔");
                break;
            case "devilSmile":
                buttonDevilSmile.setBackgroundColor(Color.parseColor("#FFD700"));
                buttonDevilSmile.setTextColor(Color.parseColor("#1E90FF"));
                buttonDevilSmile.setText("✔");
                break;
        }
    }

    private void chooseEmoji(int currEmoji, String emojiName) {
        for (int i = 0; i < buttonsEmoji.length; i++) {
            if (i == currEmoji) {
                buttonsEmoji[i].setBackgroundColor(Color.parseColor("#FFD700"));
                buttonsEmoji[i].setTextColor(Color.parseColor("#1E90FF"));
                buttonsEmoji[i].setText("✔");
            } else {
                buttonsEmoji[i].setBackgroundColor(Color.parseColor("#1E90FF"));
                buttonsEmoji[i].setTextColor(Color.parseColor("#FFFFFF"));
                buttonsEmoji[i].setText("Select");
            }
            editor = settings.edit();
            editor.putString("currentSmile", emojiName);
            editor.apply();
        }
    }

    private void createRulesLayout() {
        setContentView(R.layout.rules);
        buttonRulesBack = findViewById(R.id.buttonRulesBack);
        buttonRulesBack.setOnClickListener(v -> createMainLayout());
    }

    @SuppressLint("MissingInflatedId")
    private void createAuthorLayout() {
        setContentView(R.layout.author);
        buttonAuthorBack = findViewById(R.id.buttonAuthorBack);
        buttonAuthorBack.setOnClickListener(v -> createMainLayout());
        buttonLinkTG = findViewById(R.id.buttonLinkTG);
        buttonLinkTG.setOnClickListener(v -> {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://t.me/AleksandrPravdin"));
            startActivity(browserIntent);
        });
        buttonLinkVK = findViewById(R.id.buttonLinkVK);
        buttonLinkVK.setOnClickListener(v -> {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://m.vk.com/akf211309"));
            startActivity(browserIntent);
        });
    }

    private void createPlayFieldLayout(String level, boolean continueCurrentPlay) {
        currentLevel = level;
        setContentView(R.layout.play_field);
        initImageViewArr();
        if (!continueCurrentPlay) {
            initPlayFieldArr(level);
        }
        changePlayField();
        buttonLeft = findViewById(R.id.buttonLEFT);
        buttonLeft.setOnClickListener(v -> {
            clickMoveButton("LEFT");
        });
        buttonRight = findViewById(R.id.buttonRIGHT);
        buttonRight.setOnClickListener(v -> {
            clickMoveButton("RIGHT");
        });
        buttonUp = findViewById(R.id.buttonUP);
        buttonUp.setOnClickListener(v -> {
            clickMoveButton("UP");
        });
        buttonDown = findViewById(R.id.buttonDOWN);
        buttonDown.setOnClickListener(v -> {
            clickMoveButton("DOWN");
        });
        buttonSetting = findViewById(R.id.buttonSetting);
        buttonSetting.setOnClickListener(v -> createSettingLayout());
    }

    private void clickMoveButton(String route) {
        playFieldArr = gameLogic.move(playFieldArr, playerX, playerY, playerOnCoffee, route);
        playerOnCoffee = gameLogic.isPlayerOnCoffee();
        playerY = gameLogic.getPx();
        playerX = gameLogic.getPy();
        changePlayField();
        if (gameLogic.winGame(playFieldArr, coffeeCoordinate)) {
            createWinLevelLayout();
        }
    }

    private void initImageViewArr() {
        imageViewArr[0][0] = findViewById(R.id.imageViewPF1);
        imageViewArr[0][1] = findViewById(R.id.imageViewPF2);
        imageViewArr[0][2] = findViewById(R.id.imageViewPF3);
        imageViewArr[0][3] = findViewById(R.id.imageViewPF4);
        imageViewArr[0][4] = findViewById(R.id.imageViewPF5);
        imageViewArr[0][5] = findViewById(R.id.imageViewPF6);
        imageViewArr[0][6] = findViewById(R.id.imageViewPF7);
        imageViewArr[0][7] = findViewById(R.id.imageViewPF8);
        imageViewArr[1][0] = findViewById(R.id.imageViewPF9);
        imageViewArr[1][1] = findViewById(R.id.imageViewPF10);
        imageViewArr[1][2] = findViewById(R.id.imageViewPF11);
        imageViewArr[1][3] = findViewById(R.id.imageViewPF12);
        imageViewArr[1][4] = findViewById(R.id.imageViewPF13);
        imageViewArr[1][5] = findViewById(R.id.imageViewPF14);
        imageViewArr[1][6] = findViewById(R.id.imageViewPF15);
        imageViewArr[1][7] = findViewById(R.id.imageViewPF16);
        imageViewArr[2][0] = findViewById(R.id.imageViewPF17);
        imageViewArr[2][1] = findViewById(R.id.imageViewPF18);
        imageViewArr[2][2] = findViewById(R.id.imageViewPF19);
        imageViewArr[2][3] = findViewById(R.id.imageViewPF20);
        imageViewArr[2][4] = findViewById(R.id.imageViewPF21);
        imageViewArr[2][5] = findViewById(R.id.imageViewPF22);
        imageViewArr[2][6] = findViewById(R.id.imageViewPF23);
        imageViewArr[2][7] = findViewById(R.id.imageViewPF24);
        imageViewArr[3][0] = findViewById(R.id.imageViewPF25);
        imageViewArr[3][1] = findViewById(R.id.imageViewPF26);
        imageViewArr[3][2] = findViewById(R.id.imageViewPF27);
        imageViewArr[3][3] = findViewById(R.id.imageViewPF28);
        imageViewArr[3][4] = findViewById(R.id.imageViewPF29);
        imageViewArr[3][5] = findViewById(R.id.imageViewPF30);
        imageViewArr[3][6] = findViewById(R.id.imageViewPF31);
        imageViewArr[3][7] = findViewById(R.id.imageViewPF32);
        imageViewArr[4][0] = findViewById(R.id.imageViewPF33);
        imageViewArr[4][1] = findViewById(R.id.imageViewPF34);
        imageViewArr[4][2] = findViewById(R.id.imageViewPF35);
        imageViewArr[4][3] = findViewById(R.id.imageViewPF36);
        imageViewArr[4][4] = findViewById(R.id.imageViewPF37);
        imageViewArr[4][5] = findViewById(R.id.imageViewPF38);
        imageViewArr[4][6] = findViewById(R.id.imageViewPF39);
        imageViewArr[4][7] = findViewById(R.id.imageViewPF40);
        imageViewArr[5][0] = findViewById(R.id.imageViewPF41);
        imageViewArr[5][1] = findViewById(R.id.imageViewPF42);
        imageViewArr[5][2] = findViewById(R.id.imageViewPF43);
        imageViewArr[5][3] = findViewById(R.id.imageViewPF44);
        imageViewArr[5][4] = findViewById(R.id.imageViewPF45);
        imageViewArr[5][5] = findViewById(R.id.imageViewPF46);
        imageViewArr[5][6] = findViewById(R.id.imageViewPF47);
        imageViewArr[5][7] = findViewById(R.id.imageViewPF48);
        imageViewArr[6][0] = findViewById(R.id.imageViewPF49);
        imageViewArr[6][1] = findViewById(R.id.imageViewPF50);
        imageViewArr[6][2] = findViewById(R.id.imageViewPF51);
        imageViewArr[6][3] = findViewById(R.id.imageViewPF52);
        imageViewArr[6][4] = findViewById(R.id.imageViewPF53);
        imageViewArr[6][5] = findViewById(R.id.imageViewPF54);
        imageViewArr[6][6] = findViewById(R.id.imageViewPF55);
        imageViewArr[6][7] = findViewById(R.id.imageViewPF56);
        imageViewArr[7][0] = findViewById(R.id.imageViewPF57);
        imageViewArr[7][1] = findViewById(R.id.imageViewPF58);
        imageViewArr[7][2] = findViewById(R.id.imageViewPF59);
        imageViewArr[7][3] = findViewById(R.id.imageViewPF60);
        imageViewArr[7][4] = findViewById(R.id.imageViewPF61);
        imageViewArr[7][5] = findViewById(R.id.imageViewPF62);
        imageViewArr[7][6] = findViewById(R.id.imageViewPF63);
        imageViewArr[7][7] = findViewById(R.id.imageViewPF64);
        imageViewArr[8][0] = findViewById(R.id.imageViewPF65);
        imageViewArr[8][1] = findViewById(R.id.imageViewPF66);
        imageViewArr[8][2] = findViewById(R.id.imageViewPF67);
        imageViewArr[8][3] = findViewById(R.id.imageViewPF68);
        imageViewArr[8][4] = findViewById(R.id.imageViewPF69);
        imageViewArr[8][5] = findViewById(R.id.imageViewPF70);
        imageViewArr[8][6] = findViewById(R.id.imageViewPF71);
        imageViewArr[8][7] = findViewById(R.id.imageViewPF72);
        imageViewArr[9][0] = findViewById(R.id.imageViewPF73);
        imageViewArr[9][1] = findViewById(R.id.imageViewPF74);
        imageViewArr[9][2] = findViewById(R.id.imageViewPF75);
        imageViewArr[9][3] = findViewById(R.id.imageViewPF76);
        imageViewArr[9][4] = findViewById(R.id.imageViewPF77);
        imageViewArr[9][5] = findViewById(R.id.imageViewPF78);
        imageViewArr[9][6] = findViewById(R.id.imageViewPF79);
        imageViewArr[9][7] = findViewById(R.id.imageViewPF80);
        imageViewArr[10][0] = findViewById(R.id.imageViewPF81);
        imageViewArr[10][1] = findViewById(R.id.imageViewPF82);
        imageViewArr[10][2] = findViewById(R.id.imageViewPF83);
        imageViewArr[10][3] = findViewById(R.id.imageViewPF84);
        imageViewArr[10][4] = findViewById(R.id.imageViewPF85);
        imageViewArr[10][5] = findViewById(R.id.imageViewPF86);
        imageViewArr[10][6] = findViewById(R.id.imageViewPF87);
        imageViewArr[10][7] = findViewById(R.id.imageViewPF88);
        imageViewArr[11][0] = findViewById(R.id.imageViewPF89);
        imageViewArr[11][1] = findViewById(R.id.imageViewPF90);
        imageViewArr[11][2] = findViewById(R.id.imageViewPF91);
        imageViewArr[11][3] = findViewById(R.id.imageViewPF92);
        imageViewArr[11][4] = findViewById(R.id.imageViewPF93);
        imageViewArr[11][5] = findViewById(R.id.imageViewPF94);
        imageViewArr[11][6] = findViewById(R.id.imageViewPF95);
        imageViewArr[11][7] = findViewById(R.id.imageViewPF96);
        imageViewArr[12][0] = findViewById(R.id.imageViewPF97);
        imageViewArr[12][1] = findViewById(R.id.imageViewPF98);
        imageViewArr[12][2] = findViewById(R.id.imageViewPF99);
        imageViewArr[12][3] = findViewById(R.id.imageViewPF100);
        imageViewArr[12][4] = findViewById(R.id.imageViewPF101);
        imageViewArr[12][5] = findViewById(R.id.imageViewPF102);
        imageViewArr[12][6] = findViewById(R.id.imageViewPF103);
        imageViewArr[12][7] = findViewById(R.id.imageViewPF104);
        imageViewArr[13][0] = findViewById(R.id.imageViewPF105);
        imageViewArr[13][1] = findViewById(R.id.imageViewPF106);
        imageViewArr[13][2] = findViewById(R.id.imageViewPF107);
        imageViewArr[13][3] = findViewById(R.id.imageViewPF108);
        imageViewArr[13][4] = findViewById(R.id.imageViewPF109);
        imageViewArr[13][5] = findViewById(R.id.imageViewPF110);
        imageViewArr[13][6] = findViewById(R.id.imageViewPF111);
        imageViewArr[13][7] = findViewById(R.id.imageViewPF112);
    }

    private void initPlayFieldArr(String level) {
        InputStream inputStream = null;
        int n;
        switch (level) {
            case "level_1":
                inputStream = getResources().openRawResource(R.raw.level_1);
                break;
            case "level_2":
                inputStream = getResources().openRawResource(R.raw.level_2);
                break;
            case "level_3":
                inputStream = getResources().openRawResource(R.raw.level_3);
                break;
            case "level_4":
                inputStream = getResources().openRawResource(R.raw.level_4);
                break;
            case "level_5":
                inputStream = getResources().openRawResource(R.raw.level_5);
                break;
            case "level_6":
                inputStream = getResources().openRawResource(R.raw.level_6);
                break;
            case "level_7":
                inputStream = getResources().openRawResource(R.raw.level_7);
                break;
            case "level_8":
                inputStream = getResources().openRawResource(R.raw.level_8);
                break;
            case "level_9":
                inputStream = getResources().openRawResource(R.raw.level_9);
                break;
            case "level_10":
                inputStream = getResources().openRawResource(R.raw.level_10);
                break;
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        try {
            String ss = bufferedReader.readLine();
            playerX = Integer.parseInt(ss.split(" ")[0]);
            playerY = Integer.parseInt(ss.split(" ")[1]);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            n = Integer.parseInt(bufferedReader.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        coffeeCoordinate = new int[n][2];
        for (int i = 0; i < n; i++) {
            String sss;
            try {
                sss = bufferedReader.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            coffeeCoordinate[i][0] = Integer.parseInt(sss.split(" ")[0]);
            coffeeCoordinate[i][1] = Integer.parseInt(sss.split(" ")[1]);
        }
        for (int i = 0; i < 14; i++) {
            String s;
            try {
                s = bufferedReader.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            for (int j = 0; j < 8; j++) {
                playFieldArr[i][j] = Integer.parseInt(s.split(" ")[j]);
            }
        }
    }

    private void changePlayField() {
        for (int i = 0; i < 14; i++) {
            for (int j = 0; j < 8; j++) {
                switch (playFieldArr[i][j]) {
                    case 0:
                        imageViewArr[i][j].setImageBitmap(BitmapFactory.decodeResource(this.getResources(), R.drawable.snowbg));
                        break;
                    case 1:
                        imageViewArr[i][j].setImageBitmap(BitmapFactory.decodeResource(this.getResources(), R.drawable.icebg));
                        break;
                    case 2:
                        switch (currentSmile) {
                            case "smile":
                                imageViewArr[i][j].setImageBitmap(BitmapFactory.decodeResource(this.getResources(), R.drawable.smilewithbg));
                                break;
                            case "angrySmile":
                                imageViewArr[i][j].setImageBitmap(BitmapFactory.decodeResource(this.getResources(), R.drawable.angrysmilewithbg));
                                break;
                            case "alienSmile":
                                imageViewArr[i][j].setImageBitmap(BitmapFactory.decodeResource(this.getResources(), R.drawable.aliensmilewithbg));
                                break;
                            case "virusSmile":
                                imageViewArr[i][j].setImageBitmap(BitmapFactory.decodeResource(this.getResources(), R.drawable.virussmilewithbg));
                                break;
                            case "clownSmile":
                                imageViewArr[i][j].setImageBitmap(BitmapFactory.decodeResource(this.getResources(), R.drawable.clownsmilewithbg));
                                break;
                            case "devilSmile":
                                imageViewArr[i][j].setImageBitmap(BitmapFactory.decodeResource(this.getResources(), R.drawable.devilsmilewithbg));
                                break;
                            default:
                                imageViewArr[i][j].setImageBitmap(BitmapFactory.decodeResource(this.getResources(), R.drawable.smilewithbg));
                                break;
                        }
                        break;
                    case 3:
                        imageViewArr[i][j].setImageBitmap(BitmapFactory.decodeResource(this.getResources(), R.drawable.newicesmile));
                        break;
                    case 4:
                        imageViewArr[i][j].setImageBitmap(BitmapFactory.decodeResource(this.getResources(), R.drawable.newcoffee));
                        break;
                    case 5:
                        imageViewArr[i][j].setImageBitmap(BitmapFactory.decodeResource(this.getResources(), R.drawable.lovesmilewithbg));
                        break;
                }
            }
        }
    }

    @SuppressLint("MissingInflatedId")
    private void createSettingLayout() {
        setContentView(R.layout.setting);
        buttonContinue = findViewById(R.id.buttonContinue);
        buttonContinue.setOnClickListener(v -> createPlayFieldLayout(currentLevel, true));
        buttonReturn = findViewById(R.id.buttonReturn);
        buttonReturn.setOnClickListener(v -> {
            playerOnCoffee = false;
            createPlayFieldLayout(currentLevel, false);
        });
        buttonMenu = findViewById(R.id.buttonMenu);
        buttonMenu.setOnClickListener(v -> {
            playerOnCoffee = false;
            createMainLayout();
        });
    }

    @SuppressLint("MissingInflatedId")
    private void createWinLevelLayout() {
        setContentView(R.layout.win_level);
        editor = settings.edit();
        editor.putInt("openL" + currentLevel.substring(1), 2);
        int nextLevelOpen = Integer.parseInt(currentLevel.substring(6));
        if (nextLevelOpen < openLevels.length) {
            if (openLevels[nextLevelOpen] == 0) {
                editor.putInt("openLevel_" + (nextLevelOpen + 1), 1);
            }
        }
        editor.apply();
        TextView textView = findViewById(R.id.textViewWinLevel);
        textView.append(currentLevel.substring(6) + "!");
        buttonWinLevel = findViewById(R.id.buttonWinLevel);
        buttonWinLevel.setOnClickListener(v -> createLevelLayout());
    }
}