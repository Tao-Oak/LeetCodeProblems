
function TreeNode(val) {
  this.val = val
  this.left = this.right = null
}
/**
 * @param {number[]} inorder
 * @param {number[]} postorder
 * @return {TreeNode}
 */
var buildTree = function(inorder, postorder) {
  function helper(pl, pr, il, ir) {
    // console.log(`pl: ${pl}, pr: ${pr}, il: ${il}, ir: ${ir}`)
    if (pl > pr) return null
    let root = new TreeNode(postorder[pr])

    let middle = -1
    for (let i = il; i <= ir; i++) {
      if (inorder[i] !== postorder[pr]) {
        continue
      }
      middle = i
      break
    }
    if (middle === -1) return null
    const leftSize = middle - il
    root.left = helper(pl, pl + leftSize - 1, il, middle - 1)
    root.right = helper(pl + leftSize, pr - 1, middle + 1, ir)
    return root
  }
  return helper(0, postorder.length - 1, 0, inorder.length - 1)
}

const inorder = [9,3,15,20,7]
const postorder = [9,15,7,20,3]
console.log(buildTree(inorder, postorder))

const inorder_2 = [8, 9, 21, 3, 15, 20, 7]
const postorder_2 = [8, 21, 9, 15, 7, 20, 3]
console.log(buildTree(inorder_2, postorder_2))