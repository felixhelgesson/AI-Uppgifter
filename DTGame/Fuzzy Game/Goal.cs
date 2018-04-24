using Microsoft.Xna.Framework;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DT_Game
{
    class Goal
    {
        Vector2 pos;
        public Goal(Vector2 pos)
        {
            this.pos = pos;
        }

        public Vector2 GetGoalPos
        {
            get { return pos; }
        }
    }
}
