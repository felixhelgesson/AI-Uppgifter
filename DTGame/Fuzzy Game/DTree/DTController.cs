using DT_Game.DTree.States;
using Microsoft.Xna.Framework;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DT_Game.DTree
{
    class DTController
    {
        DTenemy e;
        Tree tree;
        ChaseState cS;
        GuardState gS;
        ScoreState sS;
        State currentState;
        Orb o;

        public DTController(DTenemy e, Orb o, Tree tree, ChaseState cS, GuardState gS, ScoreState sS, Goal pG, Goal eG)
        {
            this.e = e;
            this.tree = tree;
            this.cS = cS;
            this.gS = gS;
            this.sS = sS;
            this.o = o;
            currentState = new State(e, o, pG, eG);

            MakeDtree();
            


        }

        public Tree MakeDtree()
        {
            tree = new Tree(e);
            tree.Insert(8, o.FarFromBall, e, null);
            tree.Insert(10, true, e, gS);
            tree.Insert(6, o.EnemyHaveBall, e, null);
            tree.Insert(3, true, e, cS);
            tree.Insert(7, true, e, sS);

            Console.WriteLine(tree.DrawTree());

            return tree;
        }

        public State Behaviour(State state, Tree tree)
        {
            state = tree.Traverse();
            return state;
        }


        public void Update(GameTime gT)
        {
            currentState = Behaviour(currentState, tree);
            currentState.UpdateBehaviour(gT);

            tree = MakeDtree();
            //Console.WriteLine(tree.DrawTree());
            UpdateVariables();
            Console.WriteLine(o.FarFromBall);
        }

        void UpdateVariables()
        {
            //Console.WriteLine(o.GetDistanceToBall);
            if (o.GetDistanceToBall > 0.6)
            {
                o.FarFromBall = true;
            }
            else
                o.FarFromBall = false;

            if (o.GetDistanceToBall <= 0.1f)
            {
                o.EnemyHaveBall = true;

            }
            else
                o.EnemyHaveBall = false;

            if (e.GetDistanceToGoal <= 0.1f)
            {
                o.EnemyHaveBall = false;
                o.PlayerHaveBall = false;
                o.MadeGoal();
            }

        }
    }


}
