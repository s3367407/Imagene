package imagene.watchmaker.gp.functions.twoArg;

// Copyright 2006-2010 Daniel W. Dyer
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
//=============================================================================

import imagene.watchmaker.gp.node.BinaryNode;
import imagene.watchmaker.gp.node.Node;
import imagene.watchmaker.gp.terminals.Constant;

/***************************************
 * Written by Dorothea Baker (s3367422)*
 * for                                 *
 * Programming Project 1               *
 * SP3 2016                            *
 ***************************************/

public class Addition extends BinaryNode
{
    public Addition(Node left, Node right)
    {
        super(left, right, "plus");
    }

    public double evaluate(double[] programParameters)
    {
        return left.evaluate(programParameters) + right.evaluate(programParameters);
    }

    public Node simplify()
    {
        Node simplifiedLeft = left.simplify();
        Node simplifiedRight = right.simplify();
        // Adding zero is pointless, the expression can be reduced to its other argument.
        if (simplifiedRight instanceof Constant && simplifiedRight.evaluate(NO_ARGS) == 0)
        {
            return simplifiedLeft;
        }
        else if (simplifiedLeft instanceof Constant && simplifiedLeft.evaluate(NO_ARGS) == 0)
        {
            return simplifiedRight;
        }
        // If the two arguments are constants, we can simplify by calculating the result, it won't
        // ever change.
        else if (simplifiedLeft instanceof Constant && simplifiedRight instanceof Constant)
        {
            return new Constant(simplifiedLeft.evaluate(NO_ARGS) + simplifiedRight.evaluate(NO_ARGS));
        }
        else if (simplifiedLeft != left || simplifiedRight != right)
        {
            return new Addition(simplifiedLeft, simplifiedRight);
        }
        else
        {
            return this;
        }
    }
}
