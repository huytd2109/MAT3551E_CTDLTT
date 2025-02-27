public class Expression{
    class Node<E>{
        E element;
        Node next;
    }
    private Node<Character> stack = null;
    private int top = 0;
    private final int capacity = 100;  
    private Character[] stackArray = new Character[capacity];

    
    public void push(Character element) {
        if (top == capacity) {
            throw new IllegalStateException("Stack is full");
        }
        stackArray[top] = element;
        top++;
    }

    public Character pop() {
        if (top == 0) {
            throw new IllegalStateException("Stack is empty");
        }
        top--;
        return stackArray[top];
    }

    private boolean isEmpty() {
        return top == 0;
    }
    
    public boolean isValidExpr(String expr)
    {
        for (int i = 0; i < expr.length(); i++){
            char c = expr.charAt(i);
            if(c == '(') {
                push(c);
            }
            else if (c == ')') {
                if (isEmpty()) {
                    return false;
                }
                pop();
            }
        }
        return isEmpty();
    }
    
    public static void main(String[] args)
    {
        
        Expression expr = new Expression();
        String f = "a+b-c(3+a)";
        System.out.println(expr.isValidExpr(f));
        
    }
    
    
    
    
}
