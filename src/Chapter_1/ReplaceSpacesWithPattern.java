package Chapter_1;

/**
 * Created with IntelliJ IDEA.
 * User: sowmyahariharan
 * Date: 9/7/13
 * Time: 1:54 PM
 * To change this template use File | Settings | File Templates.
 */
public class ReplaceSpacesWithPattern {
    public static void main(String[] args){
        System.out.println(replaceSpacesWithPattern("Hello I am the String.","%20"));
        System.out.println(replaceSpacesWithPattern("Hello I am the String.","!"));
        replaceSpacesInString("Hello I am the String.","%20");
//        System.out.println(replaceSpacesInString("Hello I am the String.","%20"));
    }
    // 1. This is the book's solution
    // Not implemented completely. I don't like the way this question is framed in the book. Refer book for more details.
    private static void replaceSpacesInString(String string, String pattern){
        char[] characterArray = string.toCharArray();
        int spaceCount = 0;
        for(int i =0; i<characterArray.length; ++i){
            if(characterArray[i]==' '){
                spaceCount++;
            }
        }
        int newLength = string.length() + spaceCount*(pattern.length()-1);
        characterArray[newLength-1]='o';
        System.out.println(characterArray[newLength-1]);
    }
    // 2. This is my solution
    private static String replaceSpacesWithPattern(String string, String pattern){
        char[] characterArray = string.toCharArray();
        for(int i=0; i<characterArray.length; ++i){
            if(characterArray[i]==' '){
                // Shift the characterArray by pattern.length()-1 places
                // Then replace the '' with pattern
                characterArray = makePlacesInArray(characterArray,i,pattern.length());
                characterArray = insertPatternIntoArray(characterArray,pattern,i);
            }
        }
        return new String(characterArray);
    }
    
    private static char[] makePlacesInArray(char[] characterArray, int atIndex, int insertSize){
        int newSize = characterArray.length + insertSize;
        char[] resultCharacterArray = new char[newSize];
        for(int i=0; i<=atIndex; ++i){
            resultCharacterArray[i] = characterArray[i];  
        }
        for(int j=newSize-1, i=characterArray.length-1; i>atIndex; --j,--i){
            resultCharacterArray[j] = characterArray[i];      
        }
        return resultCharacterArray;
    }
    
    private static char[] insertPatternIntoArray(char[] characterArray, String pattern, int atIndex){
        char[] patternArray = pattern.toCharArray();
        for(int i=0; i<patternArray.length; ++i){
            characterArray[atIndex++]=patternArray[i];
        }
        return characterArray;
    }
}
