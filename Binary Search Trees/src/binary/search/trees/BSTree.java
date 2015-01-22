
package binary.search.trees;
/**
 *
 * @author geraldblake
 * This Class models the binary search tree data structure
 */
public class BSTree
{
    protected BSTNode root;
    protected int count;
    protected BSTree left;
    protected BSTree right;
    
    public BSTree()
    {
        root = null;
        count = 0;  
    }    
    /**
     * Binary Search Tree Constructor
     * @param root
     * @param count
     */
    public BSTree(BSTNode root, int count)
    {
        this.root = root;
        this.count = count;
    }
    /**
     * Binary Search Tree Constructor
     * @param count
     */
    public BSTree(int count)
    {
        this.root = null;
        this.count = count;
    }
    /**
     * Inserts into binary Search Tree uses helper method
     * @param key
     */
    public void insert(String key)
    {
        key = toUpperAndTrim(key);
        BSTNode theFound = find(key);
        if(!key.equals(""))
        {
            if(theFound == null)
            {
                root = insert(new BSTNode(key),root);
                count++;
            }
            else
            {

                theFound.setTokenCount(theFound.getTokenCount() + 1);
                count++;
            }   
        }
    }
    /**
     * Helper method inserts into tree
     * @param key
     * @param theRoot
     *
    */
    private BSTNode insert(BSTNode key, BSTNode theRoot)
    {
          if( theRoot== null ) // is empty create new node and add
             return new BSTNode(key.getToken());
          else if(key.compareTo(theRoot) < 0 ) // less than go left
             theRoot.setLeft(insert(key, theRoot.left()));
          else if( key.compareTo(theRoot) > 0 ) // greater go right
             theRoot.setRight(insert( key, theRoot.right()));
         
           return theRoot;
    }
    /**
     * Helper method inserts into tree
     * @param key
     * @param theRoot
     * @param tokenCount
    */
    private BSTNode insert(BSTNode key, BSTNode theRoot, int tokenCount)
    {
          if( theRoot== null ) // is empty create new node and add
             return new BSTNode(key.getToken(),tokenCount);
          else if(key.compareTo(theRoot) < 0 )// less than go left
             theRoot.setLeft(insert(key, theRoot.left(),tokenCount));
          else if( key.compareTo(theRoot) > 0 )
             theRoot.setRight(insert( key, theRoot.right(),tokenCount)); // greater go right
         
           return theRoot;
    }

    
    
    /**
     * finds value and returns the node
     * @param key
     * @return
     */
    public BSTNode find(String key)
     {
         return find(key,root);
     }
        private BSTNode find( String key, BSTNode theRoot)
        {
            if( theRoot == null ) // not found
                return null;
            if( key.compareTo(theRoot.getToken()) < 0 )// less go left
                return find(key,theRoot.left());
            else if( key.compareTo(theRoot.getToken()) > 0 )
                return find( key, theRoot.right()); // greater go right
            else
                return theRoot;   
        }

    /**
     * 
     * @param key
     */
    public void delete(String key)
       {
           key = toUpperAndTrim(key);
           BSTNode temp = find(key);
            if(temp!=null)
             {
                 count-= temp.getTokenCount();
                 root = delete(temp, root);
             }
             
             
        
       }
    /**
     * Finds value deletes it and returns not
     * @param key
     * @parma theRoot
     * @return theRoot
    */
      private BSTNode delete (BSTNode key, BSTNode theRoot)
      {
            if (theRoot == null)
                     // Case 1
                return theRoot;
            if(key.compareTo(theRoot) < 0 )
                    // Case 2 
                    theRoot.setLeft(delete(key, theRoot.left()));
            else if(key.compareTo(theRoot) > 0 ) 
                    // Case 3 
                    theRoot.setRight(delete(key, theRoot.right()));
            else if (theRoot.left() != null && theRoot.right() != null)
            {     // Case 4a 
                  theRoot.setToken(findMin(theRoot.right()).getToken());
                  theRoot.setRight(delete(theRoot, theRoot.right()));
            }
            else
            {
                 // Cases 4b  4d
                 theRoot = (theRoot.left() != null) 
                         ? theRoot.left() : theRoot.right();
            }
            return theRoot;
        
      }
      private BSTNode findMin(BSTNode node)
        {
            if( node == null )
                return null;
            else if( node.left() == null )
                return node;
            return findMin( node.left() );
        }

    /**
     * Trims the string removes unnecessary punctuation
     * @param theString
     * @return
     */
    public static String toUpperAndTrim(String theString)
    {
        theString = theString.trim();
        theString = theString.toUpperCase();
        String delims = "[`´“”˝’‘˙…,—.?!:;-[\'][\"]]+";
        String[] theTokens = theString.split(delims);
        String toUpperAndTrimmed="";
        
        for(String i:theTokens)
        {
            toUpperAndTrimmed += i;
        } 
        return toUpperAndTrimmed;
    }

    /**
     * Prints a BSTree using and INORDER Traversal
     */
    public void print()
    {
         System.out.format("%5s  %6s  %-20s%n","COUNT","PERCENT","TOKEN");
         System.out.format("%5s  %6s  %20s%n"
                          ,"-----","-------","--------------------");
         INORDER(root);
         System.out.print("\n\n");
    }

    /**
     * Prints a BSTree using and POSTORDER Traversal
     */
    public void printPostOrder()
    {
         System.out.format("%5s  %6s  %-20s%n"
                  ,"COUNT","PERCENT","TOKEN");
         
         System.out.format("%5s  %6s  %20s%n"
                   ,"-----","-------","--------------------");
         POSTORDER(root);
         System.out.print("\n\n");
    }
    
    /**
     * Perform in-order traversal on BST and print data
     * @param theRoot
     */
    public void INORDER(BSTNode theRoot)
    {
        if(theRoot!=null)
        {
            INORDER(theRoot.left());
            System.out.format("%5d  %6.2f%%  %s%n"
                      ,theRoot.getTokenCount()
                      ,percentage(theRoot.getTokenCount())
                      ,theRoot.getToken());
            INORDER(theRoot.right());
        }
    }

    /**
     * Perform postorder traversal on BST and print data
     * @param theRoot
     */
    public void POSTORDER(BSTNode theRoot)
    {
        if(theRoot!=null)
        {
            POSTORDER(theRoot.left());
            POSTORDER(theRoot.right());
            System.out.format("%5d  %6.2f%%  %s%n"
                      ,theRoot.getTokenCount()
                      ,percentage(theRoot.getTokenCount())
                      ,theRoot.getToken());
        }
    }
  

    /**
     * returns percentage given a parameter
     * @param tokenCount
     * @return
     */
    
    public float percentage(int tokenCount)
    {
        return (((float)tokenCount) / count()) * 100;
    }
    /**
     * Copies an entire binary search tree structure
     * @return
     */
    public BSTree copy()
     {
         return PREORDERCOPY(root, new BSTree(count));
     }
    /**
     *
     * @param theRoot
     * @param newTree
     * @return newTree
     */
    public BSTree PREORDERCOPY(BSTNode theRoot, BSTree newTree)
    {
        if(theRoot!=null)
        {
            newTree.root =  newTree.insert(theRoot,newTree.root, theRoot.getTokenCount());   
            PREORDERCOPY(theRoot.left(),newTree);
            PREORDERCOPY(theRoot.right(),newTree);
        }
        return newTree;
    }

    /**
     *
     * @return count
     */
    public int count()
    {
        return count;
    }

    /**
     *
     * @param count
     */
    public void setCount(int count)
    {
        this.count = count;
    }

    

}

