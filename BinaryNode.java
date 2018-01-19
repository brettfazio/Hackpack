// Brett Fazio, node in a binary tree. Two children.
class BinaryNode {
    
    BinaryNode left, right;
    
    int value;
    
    public BinaryNode(int v) {
        value = v;
        left = null;
        right = null;
    }
    
    public void addChild(BinaryNode cocuk) {
        if (cocuk.value > value) {
            if (right == null) {
                right = cocuk;
            }else {
                right.addChild(cocuk);
            }
        }else {
            if (left == null) {
                left = cocuk;
            }else {
                left.addChild(cocuk);
            }
        }
    }
    
    public boolean transverse(BinaryNode cocuk) {
        
        if (cocuk.left == null && this.left != null) {
            return false;
        }
        if (cocuk.left != null && this.left == null) {
            return false;
        }
        if (cocuk.right == null && this.right != null) {
            return false;
        }
        if (cocuk.right != null && this.right == null) {
            return false;
        }
        
        if (cocuk.left != null) {
            if (!this.left.transverse(cocuk.left)) {
                return false;
            }
        }
        
        if (cocuk.right != null) {
            if (!this.right.transverse(cocuk.right)) {
                return false;
            }
        }
        
        return true;
    }
    
}
