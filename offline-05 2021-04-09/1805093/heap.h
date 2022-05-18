using namespace std;

class Heap {
private:
    int* data;
    int currentIndex;
    int dataSize;

public:
    Heap(int size) {
        data = new int[size];
        currentIndex = 0;
        this->dataSize = size;
    }

    void insert(int item) {
        if(currentIndex < dataSize) {
            int i;
            for(i=currentIndex; i>0; i=(i-1)/2) {
                if(item <= data[(i-1)/2]) {
                    break;
                }
                data[i] = data[(i-1)/2];
            }
            data[i] = item;
            currentIndex++;
        }
        return;
    }

    int getMax() {
        return data[0];
    }

    void deleteKey() {
        data[0] = data[currentIndex-1];
        currentIndex--;

        int left=1;
        int right=2;
        int max;

        if(left < currentIndex && right >= currentIndex) {
            max = left;
        } else if(left < currentIndex && right < currentIndex) {
            max = data[left] > data[right] ? left : right;
        } else {
            return;
        }

        int i = 0;
        while(i < currentIndex && data[max] > data[i]) {
            int t = data[max];
            data[max] = data[i];
            data[i] = t;

            i = max;
            left=2*i+1;
            right=2*i+2;

            if(left < currentIndex && right >= currentIndex) {
                max = left;
            } else if(left < currentIndex && right < currentIndex) {
                max = data[left] > data[right] ? left : right;
            } else {
                return;
            }
        }
    }

    int size() {
        return currentIndex+1;
    }

    void print() {
        for (int i = 0; i < currentIndex ; i++) {
            cout<<data[i]<<" ";
        }
        cout<<endl;
    }
};

void heapsort(vector<int>&v){
    Heap h(v.size());
    for(int i = 0; i < v.size(); i++){
        h.insert(v[i]);
    }
    for(int i = 0; i < v.size(); i++){
        v[i]=h.getMax();
        h.deleteKey();
    }
}