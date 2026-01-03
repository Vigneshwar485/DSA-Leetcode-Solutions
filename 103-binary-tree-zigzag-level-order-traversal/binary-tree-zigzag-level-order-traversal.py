# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def zigzagLevelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        direction = 1
        stack = collections.deque([root])
        res = []

        while stack:
            level = []

            for i in range(len(stack)):
                node = stack.popleft()

                if node:
                    level.append(node.val)
                    stack.append(node.left)
                    stack.append(node.right)
            if level:
                if direction %2 == 0:
                    res.append(level[::-1])
                else:
                    res.append(level)
                direction += 1
                
        return res
        