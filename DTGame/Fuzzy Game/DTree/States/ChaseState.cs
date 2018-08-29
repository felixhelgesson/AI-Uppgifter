using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Microsoft.Xna.Framework;

namespace DT_Game.DTree.States
{
    class ChaseState : State
    {
        DTenemy enemy;
        Goal pGoal, eGoal;
        Orb o;

        public ChaseState(DTenemy enemy, Orb o, Goal pGoal, Goal eGoal) : base(enemy, o, pGoal, eGoal)
        {
            this.enemy = enemy;
            this.pGoal = pGoal;
            this.eGoal = eGoal;
            this.o = o;
        }
        public override void UpdateBehaviour(GameTime gameTime)
        {
            Vector2 diff;
            diff = o.getPos - enemy.GetEnemyPos;
            diff = Vector2.Normalize(diff);
            enemy.GetEnemyPos += diff * Constants.speed;

            enemy.getHitBoxX = (int)enemy.GetEnemyPos.X;
            enemy.getHitBoxY = (int)enemy.GetEnemyPos.Y;
            base.UpdateBehaviour(gameTime);
        }
    }
}
