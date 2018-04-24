using Microsoft.Xna.Framework;
using Microsoft.Xna.Framework.Input;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DT_Game
{
    class FuSMachine
    {
        ////Objects-----------------------------------------
        //Player p;
        //Orb o;
        //StandardEnemy stdE;
        //StandardEnemy stdE2;
        //StandardEnemy[] enemies;
        ////------------------------------------------------
        ////Goals-------------------------------------------
        //Goal eGoal, pGoal;
        ////------------------------------------------------

        //Vector2 vel;
        //float timer = 0;
        //bool goalReady = false;

        //public FuSMachine(Player p, Orb o, StandardEnemy stdE, StandardEnemy stdE2, Goal eGoal, Goal pGoal)
        //{
        //    this.p = p;
        //    this.o = o;
        //    this.stdE = stdE;
        //    this.stdE2 = stdE2;
        //    this.eGoal = eGoal;
        //    this.pGoal = pGoal;
        //    enemies = new StandardEnemy[2] { stdE, stdE2 };

        //}
        //public void Update(GameTime gT)
        //{
        //    timer++;

        //    if (o.PlayerHaveBall == true)
        //    {
        //        goalReady = false;
        //    }

        //    ReturnToGoal();
        //    ApproachBall();
        //    Score();
        //}
        //void ReturnToGoal()
        //{
        //    Vector2 diff;
        //    diff = eGoal.GetGoalPos - stdE.GetEnemyPos;
        //    diff = Vector2.Normalize(diff);
        //    if (o.GetDistanceToBall > 0.6f)
        //    {
        //        stdE.GetEnemyPos += diff / EvenWeight(stdE.GetDistanceToGoal);
        //    }
        //}
        //void ApproachBall()
        //{
        //    Vector2 diff;
        //    diff = o.getPos - stdE.GetEnemyPos;
        //    diff = Vector2.Normalize(diff);

        //    if (goalReady == false)
        //    {
        //        stdE.GetEnemyPos += diff / EvenWeight(o.GetDistanceToBall);

        //    }
        //    stdE.getHitBoxX = (int)stdE.GetEnemyPos.X;
        //    stdE.getHitBoxY = (int)stdE.GetEnemyPos.Y;
        //}
        //void Score()
        //{
        //    if (o.GetDistanceToBall <= 0.1f)
        //    {
        //        goalReady = true;
        //        Vector2 diff;
        //        diff = pGoal.GetGoalPos - stdE.GetEnemyPos;
        //        diff = Vector2.Normalize(diff);
        //        stdE.GetEnemyPos += diff / EvenWeight(stdE.GetDistanceToGoal);
        //        o.EnemyHaveBall = true;
        //        o.PlayerHaveBall = false;

        //        if (stdE.GetDistanceToGoal <= 0.1f)
        //        {

        //            o.EnemyHaveBall = false;
        //            o.PlayerHaveBall = false;
        //            o.MadeGoal();
        //            goalReady = false;
        //        }
        //    }
        //}

        //float EvenWeight(float weight)
        //{
        //    if (weight <= 0)
        //    {
        //        weight = 0.0f;
        //    }
        //    else if (weight > 1)
        //    {
        //        weight = 1f;
        //    }
        //    Console.WriteLine(weight);
        //    return weight;
        //}
    }
}
