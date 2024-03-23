#include <iostream>
#include<queue>
#include<set>

using namespace std;

class Checkout {
    
public:
    queue<int> shoppingCart;
    set<int> cord;
    Checkout() {
    }
    
    int get_max() {
        if (shoppingCart.empty()) {
            return -1;
        }
        return *cord.rbegin();
    }
    
    void add(int value) {
        shoppingCart.push(value);
        cord.insert(value);
    }
    
    int remove() {
        if (shoppingCart.empty()) {
            return -1;
        }
        int val = shoppingCart.front();
        shoppingCart.pop();
        cord.erase(val);
        return val;
    }
};

/**
 * Your Checkout object will be instantiated and called as such:
 * Checkout* obj = new Checkout();
 * int param_1 = obj->get_max();
 * obj->add(value);
 * int param_3 = obj->remove();
 */