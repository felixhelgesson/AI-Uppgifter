using Microsoft.Xna.Framework;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DT_Game.DTree
{
    class Tree
    {
        private Node root = null;
        DTenemy enemy;

        public Tree(DTenemy enemy)
        {
            this.enemy = enemy;
        }
        public Node Insert(int value, bool question,
            DTenemy enemy, State behaviour)
        {
            Node node = new Node(value, question, enemy, behaviour); try
            {
                if (root == null)
                {
                    root = node;
                }
                else Add(node, ref root); return node;
            }
            catch (Exception)
            {
                return null;
            }


        }

        private void Add(Node node, ref Node tempNode)
        {
            if (node.value > tempNode.value)
            {
                if (tempNode.right == null)
                {
                    tempNode.right = node;
                }
                else
                {
                    Add(node, ref tempNode.right);
                }
            }
            else if (node.value < tempNode.value)
            {
                if (tempNode.left == null)
                {
                    tempNode.left = node;
                }
                else
                {
                    Add(node, ref tempNode.left);
                }
            }
        }

        public State Traverse()
        {
            Node currentNode = root;

            while (currentNode != null)
            {
                if (currentNode.question == false && currentNode.left != null)
                {
                    currentNode = currentNode.left;
                    if (currentNode.behaviour != null)
                    {
                        return currentNode.behaviour;
                    }
                }
                else if (currentNode.question == true && currentNode.right != null)
                {
                    currentNode = currentNode.right;
                    if (currentNode.behaviour != null)
                    {
                        return currentNode.behaviour;
                    }
                }

            }
            return null;
        }

        public void TreeUpdate(DTenemy enemy)
        {
            Node currentNode = root;

            while (currentNode != null)
            {
                if (currentNode.question == false && currentNode.left != null)
                {
                    currentNode = currentNode.left;
                    if (currentNode.behaviour != null)
                    {

                    }
                }
                else if (currentNode.question == true && currentNode.right != null)
                {
                    currentNode = currentNode.right;
                    if (currentNode.behaviour != null)
                    {

                    }
                }

            }
        }

        public string DrawTree()
        {
            return DrawNode(root);
        }

        private string DrawNode(Node node)
        {
            if (node == null)
                return "empty"; if ((node.left == null) && (node.right == null))
                return "" + node.value; if ((node.left != null) && (node.right ==
            null))
                return "" + node.value + "(" + DrawNode(node.left) + ",	_)"; if
  ((node.right != null) && (node.left == null))
                return "" + node.value + "(_, " + DrawNode(node.right) +
                ")"; return node.value + "(" + DrawNode(node.left) + ",	" +
             DrawNode(node.right) + ")";
        }

    }
}

