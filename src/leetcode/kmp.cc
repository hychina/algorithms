#include <stdio.h>
#include <cstring>

const char* substr(const char *source, const char *target) { 
    size_t n = strlen(source);
    size_t m = strlen(target);
    int R = 256;
    int x = 0;

    int dfa[R][m];

    for (int j = 0; j < R; ++j) {
        dfa[j][0] = 0;
    }
    dfa[target[0]][0] = 1;

    for (int i = 0; i < m; ++i) {
        for (int j = 0; j < R; ++j) {
            dfa[source[j]][i] = dfa[source[j]][x];
        }
        dfa[target[i]][i] = i + 1;
        x = dfa[target[i]][x];
    }

    int current_state = 0;

    for (int i = 0; i <= n - m; ++i) { 
        current_state = dfa[source[i]][current_state];
        if (current_state == m)
            return source + i - m + 1;
    }

    return NULL;
}

int main(int argc, char const* argv[])
{
    char target[] = "abc";
    char source[] = "asdfabcasdf";
    const char *sub = substr(source, target);
    printf("%s\n", sub);
    printf("%ld\n", sub - source);
    return 0;
}
