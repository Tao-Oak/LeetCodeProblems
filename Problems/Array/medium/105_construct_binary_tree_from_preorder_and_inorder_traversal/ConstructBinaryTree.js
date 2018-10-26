//
// Created by Joshua.cao, 2018/10/12
//
// https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/
//

function TreeNode(val) {
  this.val = val
  this.left = this.right = null
}

/**
 * @param {number[]} preorder
 * @param {number[]} inorder
 * @return {TreeNode}
 */
var buildTree = function (preorder, inorder) {
  function helper(pl, pr, il, ir) {
    if (pl > pr) {
      return null
    }
    let root = new TreeNode(preorder[pl])
    let middle = -1
    for (let i = il; i <= ir; i++) {
      if (inorder[i] === preorder[pl]) {
        middle = i
        break
      }
    }
    if (middle === -1) return root

    const leftSize = middle - il
    root.left = helper(pl + 1, pl + leftSize, il, middle - 1)
    root.right = helper(pl + leftSize + 1, pr, middle + 1, ir)

    return root
  }
  return helper(0, preorder.length - 1, 0, inorder.length - 1)
}

var buildTree = function(preorder, inorder) {
  var i = p = 0;
  const build = (stop) => {
      if(inorder[i] != stop){
          var root = new TreeNode(preorder[p++]);
          root.left = build(root.val);
          i++;
          root.right = build(stop);
          return root;    
      }
      return null;        
  };
  
  return build();
};

const preorder = [3, 9, 20, 15, 7]
const inorder = [9, 3, 15, 20, 7]
console.log(buildTree(preorder, inorder))

const preorder_2 = [3, 9, 8, 21, 20, 15, 7]
const inorder_2 = [8, 9, 21, 3, 15, 20, 7]
console.log(buildTree(preorder_2, inorder_2))