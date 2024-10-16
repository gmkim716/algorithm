package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int t=0; t<10; t++) {
            int N = Integer.parseInt(br.readLine().trim());
            int[] input = new int[N];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i=0; i<N; i++) {
                input[i] = Integer.parseInt(st.nextToken());
            }

            int ans = 0;

            for (int i = 2; i < N - 2; i++) {
                int curr = input[i];

                int first = 0;
                for (int j=i-2; j<=i+2; j++) {
                    if (first < input[j]) {
                        first = input[j];
                    }
                }

                if (curr == first) {
                    int second = 0;
                    for (int j = i - 2; j <= i + 2; j++) {
                        if (j != i && second < input[j]) {
                            second = input[j];
                        }
                    }
                    ans += first - second;
                }
            }
            System.out.println("#" + (t+1) + " " + ans);

        }
        br.close();
    }
}

/** 입력 값
 * 10
 * 0 0 254 185 76 227 84 175 0 0
 * 10
 * 0 0 251 199 176 27 184 75 0 0
 * 11
 * 0 0 118 90 243 178 99 100 200 0 0
 * ...
 */

/** 출력 값
 * #1 111
 * #2 60
 * #3 165
 * ...
 */