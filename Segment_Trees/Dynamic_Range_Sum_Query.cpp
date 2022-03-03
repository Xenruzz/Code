//Alex
//AC
//https://cses.fi/problemset/task/1648/

#include <bits/stdc++.h>
using namespace std;
 
vector<long> tree;
int n, t, q;
 
long query_range(int index, int left, int right, int query_left, int query_right) {
  if (left > query_right || right < query_left) {
    return 0;
 
  }
 
  if (left >= query_left && right <= query_right) {
    return tree[index];
 
  }
 
  int mid = (left + right)/2;
  long left_node_query = query_range(2*index, left, mid, query_left, query_right);
  long right_node_query = query_range(2*index + 1, mid + 1, right, query_left, query_right);
 
  return left_node_query + right_node_query;
}
 
void query_update(int a, int b) {
  a += n;
  tree[a] = b;
  for (int i = a/2; i > 0; i /= 2) {
    tree[i] = tree[2*i] + tree[2*i + 1];
 
  }
}
 
void construct_tree() {
  for (int i = 0; i < t; i++) {
    cin >> tree[n + i];
 
  }
 
  for (int i = n - 1; i > 0; i--) {
    tree[i] = tree[2*i] + tree[2*i + 1];
 
  }
}
 
int main() {
  cin >> t >> q;
 
  n = pow(2, ceil(log2(t)));
 
  tree.resize(2*n);
 
  fill(tree.begin(), tree.end(), 0);
 
  construct_tree();
 
  for (int i = 0; i < q; i++) {
    int type, a, b;
    cin >> type >> a >> b;
 
    if (type == 1) {
      query_update(a - 1, b);
 
    } else {
      cout << query_range(1, 0, n - 1, a - 1, b - 1) << "\n";
 
    }
  }
}
