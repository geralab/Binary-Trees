/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package binary.search.trees;

/**
 *
 * @author geraldblake
 */
public class BSTNode implements Comparable
{

    // DATA MEMBERS
    private String token;
    protected int tokenCount;
    private BSTNode left;
    private BSTNode right;

    /**
     * REQUIRED BSTNODE CONSTRUCTOR
     * @param token
     */
    public BSTNode(String token)
    {
        this.token = token;
        left = null;
        right = null;
        tokenCount = 1;
    }

    /**
     * BST NODE CONTRUCTOR
     * FOR COPYING BINARY SEARCH TREE
     * @param token
     * @param tokenCount
     */
    public BSTNode(String token, int tokenCount)
    {
        this.token = token;
        left = null;
        right = null;
        this.tokenCount = tokenCount;
    }

    /**
     * RETURNS THE STRING TOKEN
     * @return token
     */
    public String getToken()
    {
        return token;
    }

    /**
     * GETS VALUE OF TOKEN COUNT
     * @return tokenCount
     */
    public int getTokenCount()
    {
        return tokenCount;
    }

    /**
     * SETS THE TOKEN COUNT TO A VALUE
     * @param tokenCount
     */
    public void setTokenCount(int tokenCount)
    {
        this.tokenCount = tokenCount;
    }

    /**
     * GETS LEFT CHILD
     * @return left
     */
    public BSTNode left()
    {
        return left;
    }

    /**
     * GETS RIGHT CHILD
     * @return right
     */
    public BSTNode right()
    {
        return right;
    }

    /**
     * SETS TOKEN
     * @param token
     */
    public void setToken(String token)
    {
        this.token = token;
    }
        
    /**
     * SETS LEFT CHILD
     * @param left
     */
    public void setLeft(BSTNode left)
    {
        this.left = left;
    }

    /**
     * SETS RIGHT CHILD
     * @param right
     */
    public void setRight(BSTNode right)
    {
        this.right = right;
    }
    @Override
    
    /**
     * this preceeds < 0
     * this equals then  0
     * this greater then > 0
     * @param o
     * @return 1,0,-1, compareTO of strings
    */
    public int compareTo(Object o) 
    {
        BSTNode obj = (BSTNode)o;
        if(this.getToken().equals(obj.getToken()))
          {
              if(this.getTokenCount() == obj.getTokenCount())
                {
                    return 0;
                }
                 else if(this.getTokenCount() < obj.getTokenCount())
                {
                    return -1;
                }
                 else if(this.getTokenCount() > obj.getTokenCount())
                {
                    return 1;
                }
            
          }
                    
          // see if this is greater than or less than
        return this.getToken().compareTo(obj.getToken());
             
    }
    
}
