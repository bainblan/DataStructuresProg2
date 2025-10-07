# DataStructuresProg2

Baines Blanton and Caleb Cort are working on this project

Baines made the simple methods in DoublyLinkedList.java, all of NodeType.java, this README file,and most of the checkstyling and debugging after functions were finished.

Caleb did the 3 complicated methods in DoublyLinkedList.java and the main bulk of the command methods in DoublyLinkedListDriver.java 

Pseudocode for deleteSubsection:
deleteSubsection(lower, upper)
    if list is empty then
        throw IllegalArgumentException

    curr = head

    while curr != null do
        next = curr.next

        if curr.info >= lower AND curr.info <=> upper then
            deleteItem(curr.info)     
        end if

        curr = next
    end while
end procedure

Big O for deleteSubsection: O(n^2)
While loop runs once per node in the list, so that’s O(n) iterations.
The if statement operations are constant-time, so O(1).
Assuming the worst, deleteItem has to run every time, so O(n)
Therefore n * n = O(n^2).

Pseudocode and Big O for reverseList: O(n)
reverseList()
    if head = null OR head.next = null then   O(1)
        return
    end if

    curr = head
    
    while curr != null do    O(n)
        temp = curr.next    O(1)
        curr.next = curr.back     O(1)
        curr.back = temp   O(1)
        curr = temp   O(1)
    end while

    temp = head    O(1)
    head = tail    O(1)
    tail = temp    O(1)
end procedure

Pseudocode and Big O for swapAlternate: O(n)
swapAlternate()
    if head = null OR head.next = null then   O(1)
        return
    end if

    curr = head

    while curr != null AND curr.next != null do   O(n)
        first  = curr              O(1)
        second = curr.next

        prev = first.back
        next = second.next

        if prev != null then
            prev.next = second
        else
            head = second
        end if

        if next != null then
            next.back = first
        else
            tail = first
        end if

        second.back = prev
        second.next = first
        first.back = second
        first.next = next

        curr = first.next
    end while
end procedure
Everything in the while loop is O(1) including the if statement on top of it, so Big O is O(n)

Baines.Blanton@uga.edu

Caleb.Cort@uga.edu

Compile: javac -d bin *.java

Run: java DoublyLinkedListDriver.java string-input.txt