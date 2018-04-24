using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Microsoft.Xna.Framework;

namespace DT_Game.DTree.States
{
    class GuardState : State
    {
        DTenemy enemy;
        Goal eGoal, pGoal;
        Orb o;
        public GuardState(DTenemy enemy, Orb o, Goal pGoal, Goal eGoal) : base(enemy, o, pGoal, eGoal)
        {
            this.enemy = enemy;
            this.eGoal = eGoal;
            this.pGoal = pGoal;
            this.o = o;

        }


        public override void UpdateBehaviour(GameTime gameTime)
        {
            Vector2 diff;
            diff = eGoal.GetGoalPos - enemy.GetEnemyPos;
            diff = Vector2.Normalize(diff);
            if (o.GetDistanceToBall > 0.6f)
            {
                enemy.GetEnemyPos += diff;
            }
            base.UpdateBehaviour(gameTime);
        }
    }
}
