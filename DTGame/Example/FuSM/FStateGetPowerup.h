#pragma once

#include "FuSMState.h"

class FStateGetPowerup : public FuSMState
{
public:
    //constructor/functions
    FStateGetPowerup(Control* parent):FuSMState(FUSM_STATE_GETPOWERUP,parent){}
    void Update(float dt);
    float CalculateActivation();
    void Exit();
};
