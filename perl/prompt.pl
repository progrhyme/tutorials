#!/usr/bin/env perl

use strict;
use warnings;

use IO::Prompt::Timeout qw(:all);

my $answer = prompt('Yes or No? (y/n)', timeout => 2);
if (has_prompt_timed_out()) {
    print "Timed out.\n";
}

use Data::Dumper;

print "Answer = $answer\n";
print Dumper $answer;
