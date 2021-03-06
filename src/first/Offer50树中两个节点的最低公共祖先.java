package first;

import utils.CommonTreeUtil;
import utils.myObject.CommonTree;

import java.util.LinkedList;
import java.util.List;

public class Offer50树中两个节点的最低公共祖先 {
    public static int result_flag = 0;

    public static void main(String[] args) {
        List<CommonTree> list = CommonTreeUtil.create();
        CommonTree lastCommonParent = getLastCommonParent(list.get(0), null, list.get(1));
        System.out.println("结果标识是：" + result_flag);
        if (lastCommonParent != null) {
            System.out.println("查找到的公共节点是：" + lastCommonParent.info);
        }

    }

    public static CommonTree getLastCommonParent(CommonTree root, CommonTree F, CommonTree H) {
        LinkedList<CommonTree> path1 = new LinkedList<CommonTree>();
        LinkedList<CommonTree> path2 = new LinkedList<CommonTree>();
        boolean result1 = getNodePath(root, F, path1);
        boolean result2 = getNodePath(root, H, path2);
        if (result1 == false && result2 == false)
            result_flag = 3;
        else if (result1 == false)//没找到找到节点1
            result_flag = 1;
        else if (result2 == false)//没找到找到节点2
            result_flag = 2;
        else //均找到节点了
        {
            return getLastCommonNode(path1, path2);
        }
        return null;
    }

    public static CommonTree getLastCommonNode(List<CommonTree> path1, List<CommonTree> path2) {//找到两个链表的公共节点,list：有序可重复
        if (path1 == null || path2 == null) {
            System.out.println("路径出错！");
            return null;
        }
        CommonTree commonNode = new CommonTree();
        int i = 0;
        while (i < path1.size() && i < path2.size() && (path1.get(i) == path2.get(i))) {
            commonNode = path1.get(i);
            i++;
        }
        return commonNode;
    }

    public static boolean getNodePath(CommonTree root, CommonTree currentNode, LinkedList linkedList)//集合LinkedList
    {
        if (root == null)
            return false;
        if (currentNode == null) {
            System.out.println("查找的节点为空");
            return false;
        }
        linkedList.add(root);
        if (root.info == currentNode.info)//加入当前节点
            return true;
        boolean result = false;
        if (!result && root.childs != null)//没找到
        {
            int i = 0;
            while (!result && i < root.childs.length) {
                result = getNodePath(root.childs[i], currentNode, linkedList);
                i++;
            }
        }
        if (!result)
            linkedList.removeLast();
        return result;
    }
}
