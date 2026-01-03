class Solution(object):
    def reverseBetween(self, head, left, right):

        stc = []

        curr = head
        pos = 1
        while pos < left:
            curr = curr.next
            pos += 1

        temp = curr
        while pos <= right:
            stc.append(temp.val)
            temp = temp.next
            pos += 1

        for v in reversed(stc):
            curr.val = v
            curr = curr.next    

        return head