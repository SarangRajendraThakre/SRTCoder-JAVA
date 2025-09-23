

public class srt {

    static final int alphabet_size=26;
    

    static class trieNode
    {

       trieNode[] t = new trieNode[alphabet_size];

        boolean isendofword;
        trieNode()
        {
            isendofword =false;
            for(int i= 0 ;i<alphabet_size;i++)
            {
                t[i]=null;
            }
        }


    
};
static trieNode root;
static void insert(String key){
    int level;
    int length=key.length();
    int index;


    trieNode pcrawl=root;
    for(level=0;level<length;level++)
    {
        index=key.charAt(level)-'a';
        if(pcrawl.t[index]==null)
        {
            pcrawl.t[index]= new trieNode();
        }
        pcrawl = pcrawl.t[index];
        pcrawl.isendofword=true;
    }

}

}

    

