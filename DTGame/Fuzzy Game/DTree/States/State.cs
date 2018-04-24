using Microsoft.Xna.Framework;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DT_Game.DTree
{
    class State
    {
        DTenemy enemy;
        Goal pGoal, eGoal;
        public State(DTenemy enemy, Orb o, Goal pGoal, Goal eGoal)
        {
            this.enemy = enemy;
            this.pGoal = pGoal;
            this.eGoal = eGoal;
        }

        public virtual void UpdateBehaviour(GameTime gameTime)
        {

        }
    }
}
