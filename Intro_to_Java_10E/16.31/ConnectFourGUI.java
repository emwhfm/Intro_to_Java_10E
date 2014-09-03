/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package connectfourgui;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;
//import javafx.util.Duration;
//import javafx.animation.FillTransition;
//import javafx.animation.Transition;

/**
 *
 * @author emwhfm
 */
public class ConnectFourGUI extends Application {
    
    private static final int ROWS = 6;
    private static final int COLS = 7;
    
    private char whoseTurn = 'R';
    
    private final Cell[][] cell = new Cell[ROWS][COLS];
    private final char[][] bookings = new char[ROWS][COLS];
    private boolean gameOver = false;
    
    private final Label lblStatus = new Label("Red's turn to play");
    
    @Override
    public void start(Stage primaryStage) {
        
        // Pane to hold cells
        GridPane pane = new GridPane();
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                pane.add(cell[i][j] = new Cell(j), j, i);
                bookings[i][j] = ' ';
            }
        }
        
        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(pane);
        borderPane.setBottom(lblStatus);
        BorderPane.setAlignment(lblStatus, Pos.CENTER);
                
        Scene scene = new Scene(borderPane);                                        
        
        primaryStage.setTitle("Connect four");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
   
    public boolean isFull() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (bookings[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
    
    public static boolean validateVector(char[] vec, char ch) {
        int countInSequence = 0;
        
        for (int i=0; i<vec.length; i++) {
            if (vec[i] == ch) {
                countInSequence++;
            }
            else {
                countInSequence = 0;
            }
            if (countInSequence == 4) {                              
                return true;
            }
        }
        return false;
    }
    
    public boolean isWon() {
        //Check rows for winner
        for (int row = 0; row < ROWS; row++) {           
            if (validateVector(bookings[row], 'R')) {                
                return true;
            }
            if (validateVector(bookings[row], 'Y')) {                
                return true;
            }
        }
        
        // Check columns for winner
        char[] tempRow = new char[ROWS];
        for (int col = 0; col < COLS; col++) {           
            for (int row = 0; row < ROWS; row++) {
                tempRow[row] = bookings[row][col];
            }
            if (validateVector(tempRow, 'R')) {                
                return true;
            }
            if (validateVector(tempRow, 'Y')) {                
                return true;
            }
        }

        // Check diagonals
        // 1/12
        char[] tempDiag = new char[ROWS];
        for (int i=0; i<4; i++) {
            tempDiag[i] = bookings[i+2][i];
        }
        if (validateVector(tempDiag, 'R')) {               
                return true;
        }
        if (validateVector(tempDiag, 'Y')) {                
                return true;
        }
        
        // 2/12
        java.util.Arrays.fill(tempDiag, '0');
        for (int i=0; i<5; i++) {
            tempDiag[i] = bookings[i+1][i];
        }
        if (validateVector(tempDiag, 'R')) {                
                return true;
        }
        if (validateVector(tempDiag, 'Y')) {              
                return true;
        }
        
        // 3/12
        java.util.Arrays.fill(tempDiag, '0');
        for (int i=0; i<6; i++) {
            tempDiag[i] = bookings[i][i];
        }
        if (validateVector(tempDiag, 'R')) {                
                return true;
        }
        if (validateVector(tempDiag, 'Y')) {                
                return true;
        }
        
        // 4/12
        java.util.Arrays.fill(tempDiag, '0');
        for (int i=0; i<6; i++) {
            tempDiag[i] = bookings[i][i+1];
        }
        if (validateVector(tempDiag, 'R')) {                
                return true;
        }
        if (validateVector(tempDiag, 'Y')) {                
                return true;
        }
        
        // 5/12
        java.util.Arrays.fill(tempDiag, '0');
        for (int i=0; i<5; i++) {
            tempDiag[i] = bookings[i][i+2];
        }
        if (validateVector(tempDiag, 'R')) {                
                return true;
        }
        if (validateVector(tempDiag, 'Y')) {                
                return true;
        }
        
        // 6/12
        java.util.Arrays.fill(tempDiag, '0');
        for (int i=0; i<4; i++) {
            tempDiag[i] = bookings[i][i+3];
        }
        if (validateVector(tempDiag, 'R')) {                
                return true;
        }
        if (validateVector(tempDiag, 'Y')) {                
                return true;
        }
        
        // 7/12
        java.util.Arrays.fill(tempDiag, '0');
        for (int i=0; i<4; i++) {
            tempDiag[i] = bookings[i][3-i];
        }
        if (validateVector(tempDiag, 'R')) {                
                return true;
        }
        if (validateVector(tempDiag, 'Y')) {                
                return true;
        }
        
        // 8/12
        java.util.Arrays.fill(tempDiag, '0');
        for (int i=0; i<5; i++) {
            tempDiag[i] = bookings[i][4-i];
        }
        if (validateVector(tempDiag, 'R')) {                
                return true;
        }
        if (validateVector(tempDiag, 'Y')) {                
                return true;
        }
        
        // 9/12
        java.util.Arrays.fill(tempDiag, '0');
        for (int i=0; i<6; i++) {
            tempDiag[i] = bookings[i][5-i];
        }
        if (validateVector(tempDiag, 'R')) {                
                return true;
        }
        if (validateVector(tempDiag, 'Y')) {                
                return true;
        }
        
        // 10/12
        java.util.Arrays.fill(tempDiag, '0');
        for (int i=0; i<6; i++) {
            tempDiag[i] = bookings[i][6-i];
        }
        if (validateVector(tempDiag, 'R')) {                
                return true;
        }
        if (validateVector(tempDiag, 'Y')) {                
                return true;
        }
        
        // 11/12
        java.util.Arrays.fill(tempDiag, '0');
        for (int i=0; i<5; i++) {
            tempDiag[i] = bookings[i+1][6-i];
        }
        if (validateVector(tempDiag, 'R')) {                
                return true;
        }
        if (validateVector(tempDiag, 'Y')) {                
                return true;
        }
        
        // 12/12
        java.util.Arrays.fill(tempDiag, '0');
        for (int i=0; i<4; i++) {
            tempDiag[i] = bookings[i+2][6-i];
        }
        if (validateVector(tempDiag, 'R')) {                
                return true;
        }
        if (validateVector(tempDiag, 'Y')) {                
                return true;
        }
        
        return false;
    }
    
    public int bookMove(int col) {
        // Check specified column full
        if (bookings[0][col] != ' ') {
            return -1;
        }
        
        // Check column empty
        if (bookings[ROWS - 1][col] == ' ') {
            bookings[ROWS - 1][col] = whoseTurn; 
            return ROWS - 1;
        } 
        
        // Find actual row in specified column
        for (int row = 1; row < ROWS; row++) {
            if (bookings[row][col] != ' ') {
                bookings[row - 1][col] = whoseTurn; 
                return row - 1;
            }
        }
        
        return -1;
    }
    
    public void handleMove(int col) {
        
        if (gameOver) {
            return;
        }
        
        int row = bookMove(col);       
        
        if (row == -1) {
            return;
        }
        
        // Light up booked circle
        if (whoseTurn == 'R') {
            cell[row][col].fill(Color.RED);
        }
        else {
            cell[row][col].fill(Color.YELLOW);
        }

        // Check game status
        if (isWon()) {            
            if (whoseTurn == 'R') {
                lblStatus.setText("Red won! The game is over");
            }
            else {
                lblStatus.setText("Yellow won! The game is over");
            }                   
            gameOver = true;
        }
        else if (isFull()) {
            lblStatus.setText("Draw! The game is over");
            gameOver = true;
        }
        else {
            // Change the turn
            whoseTurn = (whoseTurn == 'R') ? 'Y' : 'R';
            // Display whose turn
            if (whoseTurn == 'R') {
                lblStatus.setText("Red's turn to play");
            }
            else {
                lblStatus.setText("Yellow's turn to play");
            }
        }
    }
        
    public class Cell extends StackPane {
    
        private final int myColumn;
        private final Circle myCircle = new Circle(50);
        private Color myColor = Color.WHITE;
        
        public Cell(int myColumn) {
            this.myColumn = myColumn;
            setStyle("-fx-background-color: darkblue");            
            this.setPrefSize(200, 200);
            myCircle.setFill(myColor); 
            this.getChildren().add(myCircle);
            this.setOnMouseClicked(e -> handleMouseClick());  
            myCircle.centerXProperty().bind(this.widthProperty().divide(2));
            myCircle.centerYProperty().bind(this.heightProperty().divide(2));
        }
        
        public void fill(Color color) {    
            myColor = color;
            myCircle.setFill(myColor);                                              
        }
        
        /*public void flash() {                  
            FillTransition fill = new FillTransition(Duration.millis(1000), myCircle);
            fill.setFromValue(myColor);
            fill.setToValue(Color.BLACK);
            fill.setCycleCount(Transition.INDEFINITE);
            fill.setAutoReverse(true);
            fill.play();
        }*/
        
        /* Handle a mouse click event */
        private void handleMouseClick() {
            handleMove(myColumn);
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
