vector<string> generateParenthesis(int n) {
    generate("", 0, 0, n);

}

void generate(string pre, int left, int count, int n) {
    if (count == 2*n) {
        result.push_back(pre);

    } else {
        if (left < n)
            generate(pre + "(", left + 1, count + 1, n);
        if (count - left < left)
            generate(pre + ")", left, count + 1, n);
    }
}")")
}
}
