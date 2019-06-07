/*
 1. Inform an error
 2. Point to the exact place in the code with the problematic bracket
 3. find the first unmatched closing bracket which either doesn’t have an opening bracket before it, or closes the wrong opening bracket, like } in ()[}
 4. should find the first unmatched opening bracket without the corresponding closing bracket after it,like ( in {}([].
 5. If there are no mistakes, text editor should inform the user that the usage of brackets is correct.
 */
package assignment1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

class Bracket {
    Bracket(char type, int position) {
        this.type = type;
        this.position = position;
    }

    boolean Match(char c) {
        if (this.type == '[' && c == ']')
            return true;
        if (this.type == '{' && c == '}')
            return true;
        if (this.type == '(' && c == ')')
            return true;
        return false;
    }

    char type;
    int position;
}

class check_brackets {
    public static void main(String[] args) throws IOException {
        InputStreamReader input_stream = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(input_stream);
        String text = reader.readLine();

        Stack<Bracket> opening_brackets_stack = new Stack<Bracket>();
        
        for (int position = 0; position < text.length(); ++position) {
            char next = text.charAt(position);
            
            // Process opening bracket, write your code here
            if (next == '(' || next == '[' || next == '{') {
                opening_brackets_stack.push(new Bracket(next, position)); 
            }

            if (next == ')' || next == ']' || next == '}') {
                // Process closing bracket, write your code here
                if( opening_brackets_stack.empty() )
                    System.out.println(position + 1);
                else if(opening_brackets_stack.lastElement().Match(next))
                    opening_brackets_stack.pop();
                else{
                    System.out.println(position + 1);
                    }
            }
        }
                    
        // Printing answer, write your code here
        if(opening_brackets_stack.isEmpty())
            System.out.println("Success");
        if(!opening_brackets_stack.isEmpty() && opening_brackets_stack.lastElement().position == text.length() - 1)
            System.out.println(opening_brackets_stack.lastElement().position + 1);
    }
}
