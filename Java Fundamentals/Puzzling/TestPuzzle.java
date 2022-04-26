import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class TestPuzzle{
    public static void main(String[] args){
        PuzzleJava puzzleJ = new PuzzleJava();

        ArrayList<Integer> randomNumber=puzzleJ.getTenRolls();
        System.out.println(randomNumber);
        
        char randomCharacter=puzzleJ.getRandomLetter();
        System.out.println(randomCharacter);

        String showPass=puzzleJ.generatePassword();
        System.out.println(showPass);

        ArrayList<String> newPass = puzzleJ.getNewPasswordSet();
        System.out.println(newPass);
    }
}       